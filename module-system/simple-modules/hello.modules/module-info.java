module hello.modules {
  exports com.tzj.modulesystem.server;

  provides com.tzj.modulesystem.server.HelloInterface with
      com.tzj.modulesystem.server.Hello;
}