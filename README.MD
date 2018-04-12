1.log的四种日志输出级别由低到高：OFF/FATAL/ERROR/WARN/INFO/DEBUG/TRACE/ALL


2.appender为日志输出目的地，log4j提供了以下几种：
	org.apache.log4j.ConsoleAppender（控制台），
	org.apache.log4j.FileAppender（文件），
	org.apache.log4j.DailyRollingFileAppender（每天产生一个日志文件），
	org.apache.log4j.RollingFileAppender（文件大小到达指定尺寸的时候产生一个新的文件），
	org.apache.log4j.WriterAppender（将日志信息以流格式发送到任意指定的地方）
	org.apache.log4j.SMTPAppender（发送邮件输出日志）
	
	

3.layout为日志输出格式，提供了以下几种：
	org.apache.log4j.HTMLLayout（以HTML表格形式布局），
	org.apache.log4j.PatternLayout（可以灵活地指定布局模式），
	org.apache.log4j.SimpleLayout（包含日志信息的级别和信息字符串），
	org.apache.log4j.TTCCLayout（包含日志产生的时间、线程、类别等等信息）
	
	
4.layout打印参数的格式化正则表达式：
	%m   输出代码中指定的消息
　　%p   输出优先级，即DEBUG，INFO，WARN，ERROR，FATAL 
　　%r   输出自应用启动到输出该log信息耗费的毫秒数 
　　%c   输出所属的类目，通常就是所在类的全名 
　　%t   输出产生该日志事件的线程名 
　　%n   输出一个回车换行符，Windows平台为“\r\n”，Unix平台为“\n” 
　　%d   输出日志时间点的日期或时间，默认格式为ISO8601，也可以在其后指定格式，比如：%d{yyy MMM dd HH:mm:ss , SSS}，输出类似：2002年10月18日  22 ： 10 ： 28 ， 921  
　　%l   输出日志事件的发生位置，包括类目名、发生的线程，以及在代码中的行数。举例：Testlog4.main(TestLog4.java: 10 )   相当于组合%c .%M(%F:%L）
	%L   打印对应的信息的源头的代码行数
	%F   输出日志消息产生时所在的文件名称
	%%   输出一个%
	c    输出category的名称，最小长度为20  默认情况下右对齐
	%-20c   左对齐
	%。30c  多出则从左边开始截断，少的话不会补空格
	

5.配置根Logger：
	log4j.rootLogger  =   [ level ]   ,  appenderName1 ,  appenderName2 ,  …
	
	level指定log的日志输出级别，表示打印出该级别及以下的所有日志信息到指定的日志输出源中
	比如设置为info，就只会打印info/warn/error/fatal级别的日志到输出源中
	

6.log4j.Threshold：指定总的级别

7.log4j的appenderName为ConsoleAppender选项时，输出源为控制台，有如下参数：
    1.Threshold：指定日志信息的最低输出级别
    2.immediateFlush：为true表示所有信息会被立即输出不会被缓存，为false表示会缓存
    3.Target：默认为System.out
    
8.为FileAppender选项时表示输出到文件，有如下参数：
    1.Threshold
    2.immediateFlush
    3.Append：为true表示每次启动都会将日志追加到文件中，为false表示每次启动都会覆盖日志文件
    4.File：指定输出的目的日志文件
    
    
9.为DailuRollingFileAppender选项时表示每天产生一个新的日志文件，有如下参数：
    1.Threashold
    2.immediateFlush
    3.Append
    4.File
    5.DatePattern：设置滚动周期
        '.'yyyy-MM：每个月滚动一次日志文件（即产生一个新的日志文件），下一个日志文件名称为第一个文件名+.yyyy-MM
        '.'yyyyy-ww：每周
        '.'yyyy-MM-dd：每天
        '.'yyyy-MM-dd HH： 每小时
        '.'yyyy-MM-dd HH:mm：每分钟

10.为RollingFileAppender选项时表示日志文件到达指定的尺寸时产生一个新的文件，有如下参数：
    1.threshold
    2.immediateFlush
    3.Append
    4.File
    5.MaxFileSize：指定日志文件到达该大小时将会自动滚动，新文件名为第一个文件名+.1/2，该值后缀可以为KB/MB/GB
    6.MaxBackupIndex：指定可以产生的滚动文件的最大数，第一个文件不算
    
11.配置日志信息的输出格式Layout为HTMLLayout时，以HTML表格的形式布局，有如下参数：
    LocationInfo：是否输出java文件名称和行号 默认为false
    Title：表格名称，默认为Log4J Log Messages
    
12.输出格式为PatternLayout选项时，可以灵活的指定布局模式，有如下参数：
    ConversionPattern：具体的通配符在上面可以看
    
13.如果想要指定某个类输出到某个文件，可以如下，比如org.spring.learn.Test1类：
    1.先在该类中创建一个日志记录器
    2.然后再log4j的属性文件中加入如下配置；
        log4j.logger.org.spring.learn.Test1 = DEBUG, test1
        #后面的配置和一般的输出源配置一样的
        ...
    如果只是这样的配置的话，那么如果A的配置如果包含该配置的话，A的日志文件也是
    会打印它的日志的，如果想要只让他们输出到自己指定的日志中，可以使用log4j的一个开关
    log4j.additivity.appenderName：用于指定输出源是否同时输出到log4j.rootLogger配置的日志中
    (个人测试log4j.additivity.appenderName是无效的)
    
    这里一定要注意的是：增加的输出源的键位log4j.logger.+类路径
    
14.网上说：当再java类的main方法中进行测试的时候，是不会再日志文件中添加日志信息的，暂时没看懂是什么意思
    百度了一下好像是说，只能通过web形式才能输出日志，直接通过main方法启动是不行的，test2
   貌似是可以的，只不过需要自己手动来找到对应的log4j配置文件
   
   
15.解决log4j的乱码：log4j.appender.appenderName.Encoding=...
    控制台使用的是utf-8编码，日志文件中使用的是gbk。。。
   在这里我使用了utf-8发现还是乱码，使用GBK之后发现好了。。。
   不能证明什么，只能说明这个属性是有用的 