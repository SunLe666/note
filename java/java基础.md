拆箱和装箱：
	装箱（boxing）是将值类型转换为引用类型。例如：int转Integer
	装箱过程是通过调用包装类的valueOf方法实现的。
	
	拆箱（unboxing）是将引用类型转换为基本数据类型。例如:Integer转int
	拆箱过程是通过调用包装类的xxxValue方法实现的。（xxx代表对应的基本数据类型）
	
	
访问控制修饰符：
	puclic:表示任何类都可以访问
	包访问权限：没有任何修饰符，他表示当前包所有类都可以访问，其他包的类无法访问。
	protected:表示子类可以访问，同一个包下的其他类可以访问，即使这些类不是子类。
	private：表示任何其他类都无法访问。
	
	

重载/重写:
	重载：方法的重载（Overload）是指方法名称相同，但参数的类型或参数个数不相同。通过传递参数的个数及类型的不同可以完成不同功能的方法调用。
	
	重写：是指子类定义了与父类中同名的方法，但是在方法重写时必须要考虑到访问权限，子类重写的方法不能拥有比父类更严格的访问权限。

	
switch :判断一个变量与一系列值中某个值是否相等，每个值称为一个分支。


java异常处理中finally中的return会覆盖catch代码块的return语句和throw语句，所以java不建议在finally中使用return语句。


序列化：是将对象转成字节流。
	可以将对象的字节序列化---保存在内存、文件、数据库中
	RMI远程方法调用

反序列化：是将字节类转换成对象。

对象序列化不会关注类中的静态变量。

必须实现java.io.Serializable


为什么需要泛型？
	编译时的强制检查。避免了类型转换。
	

泛型约束：
	类型参数不能时值类型
	不能创建参数的实例。
	不能声明类型为类型参数的静态成员
	参数类型不能使用类型转换或instanceof
	不能创建参数类型的数组
	不能创建catch或throw参数化类型对象。
	仅仅是泛型类相同，而参数类型不同的方法不能重载
	
	泛型命名
		E-Element
		K-Key
		N-Number
		T-type
		V-value
	
	使用建议：
		List优先数组
		优先考虑使用泛型来提高代码通用性
		优先考虑泛型方法来限定泛型的范围
		利用有限制的通配符来提升代码的灵活性
		优先考虑类型安全的异构容器

		
反射：	
	通过反射机制，可以运行时访问java对象的属性，方法，构造方法等。
		注解、动态代理、
		
	获得对象
		用Class对象的forName静态方法。
		直接获取某一对象的class
		调用Object的getClass方法。
		

