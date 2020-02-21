### 1.lombk 常见注解

```
@Data 注解在类上；提供类所有属性的 getting 和 setting 方法，此外还提供了equals、canEqual、
hashCode、toString 方法
@Setter ：注解在属性上；为属性提供 setting 方法
@Setter ：注解在属性上；为属性提供 getting 方法
@NoArgsConstructor ：注解在类上；为类提供一个无参的构造方法
@AllArgsConstructor ：注解在类上；为类提供一个全参的构造方法

```
 




### 1.idea 自带接口测试工具的测试示例
 
```
### 新增
POST http://localhost:9001/company
Accept: */*
Cache-Control: no-cache
Content-Type: application/json;charset=UTF-8

{ 	"name":"超级大侠1", "managerId":"11242" 	}

###

### 更新
PUT http://localhost:9001/company/1230775277492133888
Accept: */*
Cache-Control: no-cache
Content-Type: application/json;charset=UTF-8

{ 	"name":"超级大侠1111", "managerId":"112421111" 	}

<> 2020-02-21T044859.500.json

###

```

### 3.数据库三范式

三范式：
1.第一范式（1NF）：确保每一列的原子性（做到每列不可拆分）
2.第二范式（2NF）：在第一范式的基础上，非主字段必须依赖于主字段（一个表只做一件事）
3.第三范式（3NF）：在第二范式的基础上，消除传递依赖

反三范式：
反三范式是基于第三范式所调整的，没有冗余的数据库未必是最好的数据库，有时为了提高运行效率，就必须降低
范式标准，适当保留冗余数据。
