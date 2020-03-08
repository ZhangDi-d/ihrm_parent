package com.ihrm;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Date;
import java.util.concurrent.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TokenTest {
    private String token = null;
    private final CountDownLatch cdl = new CountDownLatch(1);

    //CountDownLatch
    @Test
    public void test0() {
        Thread thread = new Thread(() -> {
            createToken();
            cdl.countDown();//此方法是CountDownLatch的线程数-1
        });
        thread.start();
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        parserToken();
    }

    //Future
    @Test
    public void test1() {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Thread thread = new Thread(this::createToken);
        Future<?> future = executorService.submit(thread);
        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        parserToken();
    }

    //while循环
    @Test
    public void test2() {
        Thread t = new Thread(this::createToken);
        t.start();
        while (t.isAlive()) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        parserToken();
    }

    //join
    @Test
    public void test3() {
        Thread t = new Thread(this::createToken);
        t.start();
        try {
            t.join();  //阻塞当前线程，让t先执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        parserToken();

    }

    /**
     * 解析token
     */
    private void parserToken() {
        System.out.println("------------------parse begin--------------------");
        Claims claims = Jwts.parser().setSigningKey("alibaba").parseClaimsJws(token).getBody();
        System.out.println("id=" + claims.getId());
        System.out.println("subject=" + claims.getSubject());
        System.out.println("IssuedAt=" + claims.getIssuedAt());
        System.out.println("自定义=" + claims.get("address"));
        System.out.println("------------------parse begin--------------------");
    }

    /**
     * 创建token
     */
    private void createToken() {
        System.out.println("------------------create begin--------------------");
        JwtBuilder builder = Jwts.builder().setId("111").setSubject("zhangsan").setIssuedAt(new Date()).
                signWith(SignatureAlgorithm.HS256, "alibaba").claim("address", "alogonima");
        String token = builder.compact();
        this.token = token;
        System.out.println(token);
        System.out.println("------------------create end--------------------");
    }
}
