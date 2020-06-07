import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author 306548063@qq.com
 * @Desc
 * @date 2020/6/6 0:56
 */
public class CodeGenerator {

    private static String url = "jdbc:mysql://localhost:3306/moolng_attendance_system?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=UTC";
    private static String driverClass = "com.mysql.cj.jdbc.Driver";
    private static String userName = "root";
    private static String password = "root";
    private static String projectName = "moolng-mybatis-plus-demo";
//    private static String projectName = "moolng-mybatis-plus-generator";
//    private static String projectName = "moolng-user";
    private static String moduleName = "test";
    private static String packagePath = "com.moolng";
    private static String[] tableNames = {"sys_attendance_record"};

//    /**
//     * controller，service，entity, mapper，mapperXML 重新覆盖创建
//     **/
//    private static boolean overCreateFile = true;
//    /**
//     * 自动创建controller类
//     **/
//    private static boolean createService = true;
//    /**
//     * 自动创建service类
//     **/
//    private static boolean createController = false;
//    /**
//     * 自动创建mapper类
//     **/
//    private static boolean createMapper = false;
//    /**
//     * 自动创建xxxMapper.xml文件
//     **/
//    private static boolean createMapperXML = false;
//    /**
//     * 自动创建entity类
//     **/
//    private static boolean createEntity = true;

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir") + "/" + projectName;
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("李权");
        gc.setOpen(false);
        // gc.setSwagger2(true); 实体属性 Swagger2 注解

        gc.setBaseResultMap(true);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setBaseColumnList(true);


        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(url);
        // dsc.setSchemaName("public");
        dsc.setDriverName(driverClass);
        dsc.setUsername(userName);
        dsc.setPassword(password);

        // 设置自定义数据库字段类型转换
        dsc.setTypeConvert(new MyITypeConvert());

        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
//        pc.setModuleName(scanner("模块名"));
        pc.setModuleName(moduleName);
        pc.setParent(packagePath);
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

//        InjectionConfig cfg = new InjectionConfig() {
//            //自定义属性注入:abc
//            //在.ftl(或者是.vm)模板中，通过${cfg.abc}获取属性
//            @Override
//            public void initMap() {
//                Map<String, Object> map = new HashMap<>();
//                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
//                this.setMap(map);
//            }
//        };
        //配置自定义属性注入
        mpg.setCfg(cfg);


        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录，自定义目录用");
                if (fileType == FileType.MAPPER) {
                    // 已经生成 mapper 文件判断存在，不想重新生成返回 false
                    return !new File(filePath).exists();
                }
                // 允许生成模板文件
                return true;
            }
        });
        */
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

        // 不创建controller
//        templateConfig.setController("");
        // 不创建service
//        templateConfig.setService("");
        // 不出serviceImpl
//        templateConfig.setServiceImpl("");
        // 不创建entity
//        templateConfig.setEntity("");
        // 不创建mapper
//        templateConfig.setMapper("");
        // 不创建mapperXML
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
        strategy.setEntityLombokModel(true);
//        strategy.setRestControllerStyle(true);
        // 公共父类
        strategy.setSuperEntityClass(com.baomidou.mybatisplus.extension.activerecord.Model.class);
//        strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
        strategy.setSuperMapperClass("com.baomidou.mybatisplus.core.mapper.BaseMapper");
        // 写于父类中的公共字段
//        strategy.setSuperEntityColumns("id");
//        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        strategy.setInclude(tableNames);
        strategy.setRestControllerStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");


        strategy.setEntityBooleanColumnRemoveIsPrefix(true);
//        strategy.setEntityTableFieldAnnotationEnable(true);
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}
