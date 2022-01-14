pom文件中的packaging：
如果没有设置项目类型，则默认是jar
pom文件中的scope:
provided:jar包只在编译中使用，该jar包不带入运行环境，可能是运行环境已经有类似的jar包或者只是为了编译通过。
test:jar只在编译运行测试用例时才会使用。
runtime:jar包在运行时使用，即随声携带,因此，写不写都没太大意义。
compile:编译及后续阶段都使用，如果依赖没写，则默认是用的这个compile