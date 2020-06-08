package com.moolng.test.config;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 创建API应用
 * api() 增加API相关信息
 * 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
 * 本例采用指定扫描的包路径来定义指定要建立API的目录。
 *
 * @return
 */
@EnableSwagger2
@Configuration
public class Swagger2Config {

    // 定义分隔符
    private static final String splitor = ";";


    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("积分系统")
                .description("积分系统描述")
                .version("1.0.0")
                .termsOfServiceUrl("www.xueeyou.com")
                .build();
    }

    /**
     * ======================================= 【配置方法一】 开始 =======================================
     * 支持按住选择
     **/
    @Bean
    public Docket docket1() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("group1")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.moolng.test.controller"))
                .paths(PathSelectors.any()) //可以根据url路径设置哪些请求加入文档，忽略哪些请求
                .build();
    }

    @Bean
    public Docket docket2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("group2")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.moolng.test.app.controller"))
                .paths(PathSelectors.any()) //可以根据url路径设置哪些请求加入文档，忽略哪些请求
                .build();
    }
    /**======================================= 【配置方法一】 结束 =======================================**/


    /**
     * ======================================= 【配置方法二】 开始 =======================================
     **/
//    public static Predicate<RequestHandler> basePackage(final String basePackage) {
//        return input -> declaringClass(input).transform(handlerPackage(basePackage)).or(true);
//    }
//
//    private static Function<Class<?>, Boolean> handlerPackage(final String basePackage) {
//        return input -> {
//            // 循环判断匹配
//            for (String strPackage : basePackage.split(splitor)) {
//                boolean isMatch = input.getPackage().getName().startsWith(strPackage);
//                if (isMatch) {
//                    return true;
//                }
//            }
//            return false;
//        };
//    }
//
//    private static Optional<? extends Class<?>> declaringClass(RequestHandler input) {
//        return Optional.fromNullable(input.declaringClass());
//    }
//
//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(basePackage("com.moolng.test.controller" + splitor + "com.moolng.test.app.controller")) // controller的根目录 全部在同一个页面展示
//                .paths(PathSelectors.any()) // 可以根据url路径设置哪些请求加入文档，忽略哪些请求
//                .build();
//    }
    /**======================================= 【配置方法二】 结束 =======================================**/


}
