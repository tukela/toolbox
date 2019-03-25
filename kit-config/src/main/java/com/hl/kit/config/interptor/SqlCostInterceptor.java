//package com.hl.kit.config.interptor;
//
//import org.aopalliance.intercept.Interceptor;
//import org.apache.ibatis.executor.statement.StatementHandler;
//import org.apache.ibatis.plugin.Intercepts;
//import org.apache.ibatis.plugin.Signature;
//import org.apache.ibatis.session.ResultHandler;
//import org.apache.log4j.Logger;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//
//import java.lang.annotation.Annotation;
//import java.sql.Statement;
//import java.util.Properties;
//
//
//@Component
//@Configuration
//@Intercepts({@Signature(type = StatementHandler.class, method = "query", args = {Statement.class, ResultHandler.class}),
//        @Signature(type = StatementHandler.class, method = "update", args = {Statement.class}),
//        @Signature(type = StatementHandler.class, method = "batch", args = { Statement.class })})
//public class SqlCostInterceptor implements Interceptor {
//
//    Logger log = Logger.getLogger(SqlCostInterceptor.class);
//
//    @Override
//    public Object intercept(Invocation invocation) throws Throwable {
//
//        long startTime = System.currentTimeMillis();
//        try {
//            return invocation.proceed();
//        } finally {
//            long endTime = System.currentTimeMillis();
//            long sqlCost = endTime - startTime;
//            System.out.println("执行耗时 : [" + sqlCost + "ms ] ");
//        }
//    }
//
//    @Override
//    public Object plugin(Object target) {
//        SqlInterConfig config = new SqlInterConfig();
//        Annotation[] aaa =  config.getClass().getAnnotations();
//
//        return Plugin.wrap(target, config );
//    }
//
//    @Override
//    public void setProperties(Properties properties) {
//
//    }
//}
