# SpringBoot Util

> 介于代码的复用性，作者突发奇想，想搞点工具写着，仅供参考。另外，所有代码都是作者在本地跑通了以后才上传的，如果读者跑不通，大概率是环境问题，可以联系作者。

## MybatisPlusDemo
-  MyBatisPlus工具
- 主要内容
    - mybatis-plus的整合
        - application.yaml对mysql和mybatis-plus的配置
        - mapper接口（继承BaseMapper）
        - 拦截器配置类（分页才会生效）
    - Transactional注解
        - 原子性

## KafkaDemo
- Kafka工具
- 主要内容
    - 环境搭建
        - kafka依赖zookeeper，先启动zookeeper：`.\zkServer`
        - 再启动kafka：`.\bin\windows\kafka-server-start.bat .\config\server.properties`
    - kafka的整合
        - 配置application.yml
        - producer
            - 同步producer
            - 异步producer
        - consumer
        - 为了监听异步producer，使用ProducerListener


## GlobalExceptionDemo
- **全局异常处理**和**通用返回结果**工具
- 主要内容
    - 全局异常处理
        - @ControllerAdvice
        - @ExceptionHandler
        - @ResponseBody
    - 通用返回结果
        - enum ErrCode
        - ResultCode implements ErrCode
        - CommonResult 自定义通用返回结果
        - 自定义异常类 extends RuntimeException
