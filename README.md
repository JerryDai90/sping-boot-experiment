# sping-boot-experiment
解决spring boot 目前存在问题，已经验证相关方法的可行性

## 1. feign 问题
* feign 中存在 post 请求变 get 请求，然后把参数拼接到url上问题修复。详情看：[https://zhuanlan.zhihu.com/p/112568946](https://zhuanlan.zhihu.com/p/112568946)

* feign 中存在 + 号没有转义。详情看：[https://zhuanlan.zhihu.com/p/113376831](https://zhuanlan.zhihu.com/p/113376831)


