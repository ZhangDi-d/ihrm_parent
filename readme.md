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
