# spring_boot_server_starter

## Overview

A spring boot server starter, which contains some examples.

## Objective

To help developers start to build spring boot server as quickly as possible. This starter works only when the web app is very lightweight(such as a school project).

## Example Description

1. Transaction Example
    - 业务情景：论坛管理员一次给大量用户加100积分。
    - 回滚规则：
        1. 用户不存在时打印log，循环结束后统一抛出异常，不回滚。
        2. 任一用户加分失败抛出异常，回滚。
2. 作为RESTFUL web service client访问其它服务器提供的RESTFUL服务。本例子为使用gitlab apiv3从gitlab私服中取出特定代码仓库里的全部代码。
