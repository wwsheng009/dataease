package io.dataease.provider.query.saphana;

import io.dataease.provider.query.SQLConstants;

import static io.dataease.commons.constants.DatasourceTypes.sap_hana;

/**
 * @Author gin
 * @Date 2021/7/8 7:22 下午
 */
public class SAPHanaConstants extends SQLConstants {
    public static final String KEYWORD_TABLE = sap_hana.getKeywordPrefix() + "%s" + sap_hana.getKeywordSuffix();

    public static final String KEYWORD_FIX = "%s." + sap_hana.getKeywordPrefix() + "%s" + sap_hana.getKeywordSuffix();

    public static final String ALIAS_FIX = sap_hana.getAliasPrefix() + "%s" + sap_hana.getAliasSuffix();

    public static final String UNIX_TIMESTAMP = "UNIX_TIMESTAMP(%s)";

    public static final String DATE_FORMAT = "to_timestamp(%s,'%s')";

    public static final String FROM_UNIXTIME = "FROM_UNIXTIME(%s,'%s')";

    public static final String CAST = "CAST(%s AS %s)";

    public static final String DEFAULT_DATE_FORMAT = "YYYY-MM-DD HH24:MI:SS";

    public static final String DEFAULT_INT_FORMAT = "DECIMAL(20,0)";

    public static final String DEFAULT_FLOAT_FORMAT = "DECIMAL(20,2)";

    public static final String WHERE_VALUE_NULL = "(NULL,'')";

    public static final String WHERE_VALUE_VALUE = "'%s'";

    public static final String AGG_COUNT = "COUNT(*)";

    public static final String AGG_FIELD = "%s(%s)";

    public static final String WHERE_BETWEEN = "'%s' AND '%s'";

    public static final String BRACKETS = "(%s)";

    public static final String TO_NUMBER = "TO_NUMBER(%s)";

    public static final String TO_DATE = "TO_DATE(%s,'%s')";

    public static final String TO_CHAR = "TO_CHAR(%s,'%s')";

    public static final String DEFAULT_START_DATE = "'1970-01-01 8:0:0'";

    public static final String TO_MS = " * 24 * 60 * 60 * 100";

    public static final String CALC_SUB = "%s - %s";
}
