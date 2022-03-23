package io.dataease.dto.datasource;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;


@Getter
@Setter
public class SapHanaConfiguration extends JdbcConfiguration {
    private String driver = "com.sap.db.jdbc.Driver";
    private String extraParams = "";
    public String getJdbc(){
        if(StringUtils.isEmpty(extraParams.trim())){
            //jdbc:sap://172.18.3.166:30215/?databaseName=HDB&user=SAPHANADB&password=Clean_123
            return "jdbc:sap://HOSTNAME:PORT/?databaseName=DATABASE"
                    .replace("HOSTNAME", getHost().trim())
                    .replace("PORT", getPort().toString().trim())
                    .replace("DATABASE", getDataBase().trim());
        }else {
            return "jdbc:sap://HOSTNAME:PORT/?DatabaseName=DATABASE&EXTRA_PARAMS"
                    .replace("HOSTNAME", getHost().trim())
                    .replace("PORT", getPort().toString().trim())
                    .replace("DATABASE", getDataBase().trim())
                    .replace("EXTRA_PARAMS", getExtraParams().trim());
        }
    }
}
