# Aspectj是什么
The motivation for AspectJ (and likewise for aspect-oriented programming) is the realization that
there are issues or concerns that are not well captured by traditional programming methodologies.
AspectJ（包括相同的面向切面编程）的初衷是意思到在传统的编程方法论中有一些问题和关注点没有被很好的处理

Consider the problem of enforcing a security policy in some application.
考虑一个在应用程序中实施一个安全策略

By its nature, security cuts across many of the natural units of modularity of the application.
天然的，安全跨越应用程序的多个模块化单元

Moreover, the security policy must be uniformly applied to any additions as the application evolves.
此外，安全策略在程序迭代的过程中必须被一致的应用在任何附加条件下

And the security policy that is being applied might itself evolve.
并且安全策略在迭代的时候可能正在被应用

Capturing concerns like a security policy in a disciplined way is difficult and error-prone in a
traditional programming language.
在传统的编程语言中要严格的处理好像安全策略的问题是很难的并且容易出错的

Concerns like security cut across the natural units of modularity.
For object-oriented programming languages, the natural unit of modularity is the class.
涉及像安全这样跨约自然的模块化单元，在面向对象编程语言中是类

But in object-oriented programming languages,
crosscutting concerns are not easily turned into classes precisely because they cut across classes,
但是在面向对象编程语言，涉及横切没法被简单精确的分成类，因为需要横切多个类

and so these aren't reusable, they can't be refined or inherited,
因此也没法被重用，也没法被提炼或者继承
they are spread through out the program in an undisciplined way, in short, they are difficult to work with.
这些横切在程序中以无规则的方式分布，简单说，这些横切是很难被处理的

Aspect-oriented programming is a way of modularizing crosscutting concerns much like
object-oriented programming is a way of modularizing common concerns.
面向切面编程可以像面向对象编程模块化通用关注点一样模块化横切

Join point：连接点
Pointcut：切入点
Advice：增强（这个似乎翻译得不对）
inter-type declarations：类型间声明
Aspect：切面
Introduction：引入
Target object：目标对象
AOP Proxy：AOP代理
Weaving：编织


Advice类型：
- Before advice：在连接点之前执行增强，但无法阻止执行流前进到接入点，除非增加抛出异常
- After returning advice：在连接点正常执行完毕后执行增强，如果连接点抛出异常不会执行增强
- After throwing advice：在方法抛出异常退出的时候执行增强
- After (finally) advice：在方法退出后执行，无论方法是正常退出还是异常退出
- Around advice：环绕接入点，环绕增强可以自定义方法执行前后执行后的表现，也可以控制是否执行接入点，
也可以增加方法自己返回结果作为接入点的放回结果，也可以抛出异常


知识点：
- Spring AOP是运行时增强，AspectJ本身是编译时增加（需要使用AspectJ自身的编译器和语法）
- 在Spring中AOP代理是通过JDK动态代理或者CGLIB代理实现
- Spring是在运行时织入
- Spring中连接点必须时函数执行（在AspectJ中还可以是函数调用、函数执行、构造函数调用、构造函数执行、
获取某个变量、设置某个变量、初始化之前、初始化、静态初始化、异常处理、增加执行）
-
