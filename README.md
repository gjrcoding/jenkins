# jenkins

## pipeline支持的指令

*   enviroment：用于设置环境变量，可定义在stage或pipeline部分
*   tools：可定义在pipeline或stage部分，它会自动下载并安装我们指定的工具，并将其加入PATH变量
*   input：定义在stage部分，会暂停pipeline，提示你输入内容
*   options：用于配置jenkins pipeline本身的选项，比如options{ retry(3)}指当pipeline失败时再重试2次。options可以定义在stage或pipeline部分
*   parallel：并行执行多个step.
*   parameters：与input不同，parameters是执行pipeline前传入的一些参数
*   triggers：用于定义执行pipeline的触发器
*   when：当满足when定义的条件时，阶段才执行
