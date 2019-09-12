面向切面编程（AOP）:将可以重复性的横切逻辑抽取到统一的模块中。
例如日志打印、安全监测，如果按照 OOP 的思想，在每个方法的前后都要加上重复的代码，之后要修改的话，更改的地方就会太多，导致不好维护。
所以出现了 AOP 编程， AOP 所关注的方向是横向的，不同于 OOP 的纵向

1.创建用于拦截的 bean
@Aspect //让Spring认识到这个是一个切面bean
public class AspectJTest {

	@Pointcut("execution(* *.testAop(..))")//表示这是一个切点方法，execution() 内部的表达式指明被拦截的方法
	public void test() {

	}

  //Before 、After、Around 分别表示在被拦截方法的前、后已经环绕执行。
	@Before("test()")
	public void beforeTest() {
		System.out.println("before Test");
	}


	@After("test()")
	public void afterTest() {
		System.out.println("after Test");
	}

	@Around("test()")
	public Object aroundTest(ProceedingJoinPoint joinPoint) {
		System.out.println("around Before");
		Object o = null;
		try {
			// 调用切面的方法
			o = joinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("around After");
		return o;
	}
}

2.创建配置文件 aop.xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	   xmlns:aop="http://www.springframework.org/schema/aop"
	   xsi:schemaLocation="http://www.springframework.org/schema/beans
	   http://www.springframework.org/schema/beans/spring-beans.xsd
	   http://www.springframework.org/schema/aop
	   https://www.springframework.org/schema/aop/spring-aop.xsd">
    <!--开启 AOP 功能-->
	<aop:aspectj-autoproxy />

	<bean id="aopTestBean" class="aop.TestAopBean"/>

	<bean class="aop.AspectJTest" />
</beans>

3.测试Demo
public class AopTestBootstrap {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("aop/aop.xml");
		TestAopBean bean = (TestAopBean) context.getBean("aopTestBean");
		bean.testAop();
		// 输出内容 看输出顺序，了解到增强方法的执行顺序 :
		// Around proceed 之前 -> Before -> Around proceed 之后 -> After
		//around Before
		//before Test
		//I am the true aop bean
		//around After
		//after Test
	}
}


