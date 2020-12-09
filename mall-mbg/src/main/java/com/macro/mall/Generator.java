package com.macro.mall;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Code used to produce MBG
 * Created by macro on 2018/4/26.
 */
public class Generator {
    public static void main(String[] args) throws Exception {
        //Warning messages during MBG execution
        List<String> warnings = new ArrayList<String>();
        //When the generated code is repeated, the original code is overwritten
        boolean overwrite = true;
        //Read our MBG configuration file
        InputStream is = Generator.class.getResourceAsStream("/generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(is);
        is.close();

        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        //Create MBG
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        //Execute build code
        myBatisGenerator.generate(null);
        //Output warning information
        for (String warning : warnings) {
            System.out.println(warning);
        }
    }
}
