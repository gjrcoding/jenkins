//以下每个部分(section)都是必须的，少一个jenkins都会报错
//pileline：代表整个流水线，包含整条流水线的逻辑
pileline{
    
    options{
        //保存最近历史构建记录的数量，如果长时间不清理会占用大量空间
        buildDiscarder(logRotator(numToKeepStr:'10'))

        //拉取源码时，默认检出到工作空间的根目录中，此选项可以指定检出到工作空间的子目录中
        checkoutToSubdirectory('subdir')

        //同一个pipeline，jenkins默认是可以同时执行多次的，此选项是为了禁止pipeline同时执行
        disableConcurrentBuilds()

        //当agent为docker或dockerfile时，指定在同一个jenkins节点上，每个stage都分别运行在一个新的容器中，而不是所有stage都运行在同一个容器中
        newContainerPerStage()

        //指定pipeline的重试次数，这个次数是指总次数，包含第一次的失败
        retry(4)

        //超过timeout时间，jenkins将终止，单位可以是HOURS、SECONDS、MINUTES
        timeout(time:10, unit:'HOURS')
    }

    //指定流水线的执行位置。流水线中的每个阶段都必须在某个地方（物理机、虚拟机或Docker容器）执行，agent部分即指定具体在哪里执行。
    agent any
    //流水线中多个stage的容器，至少包含一个stage
    stages{
        //阶段，代表流水线的阶段，每个阶段都必须有名称
        stage('build'){
            //代表阶段中的一个或多个具体步骤的容器，steps至少包含一个步骤
            steps{
                echo "hello world"
            }
        }

        stage('script'){
            //代表阶段中的一个或多个具体步骤的容器，steps至少包含一个步骤
            steps{
                script{
                    //可以在此写groovy代码，比如if-else等大量的逻辑
                }
            }
        }
    }

    // always\changed\fixed\regression\aborted\failure\success\unstable\cleanup
    post{
        changed{
            echo "pipeline post changed"
        }

        always{
            echo "pipeline post always"
        }

        success{
            echo "pipeline post success"
        }
    }
}