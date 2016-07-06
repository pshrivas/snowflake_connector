package com.unicosolution.adapter.snowflakev2.cci.deploy;

import java.util.HashMap;
import java.util.UUID;
import com.informatica.cloud.adapter.cci.boot.CCIBootPlugin;
import com.informatica.cloud.api.adapter.plugin.IPluginExtension;
import com.informatica.cloud.adapter.cci.boot.CCIBootPlugin;
import com.informatica.cloud.api.adapter.plugin.IPluginExtension;

public class SnowflakeV2Plugin extends CCIBootPlugin  implements IPluginExtension {

    static final String uuid = "898ba5dc-1c68-491d-a27e-982f40c4ad70";

    static final String ADAPTER_ID = "com.unicosolution.adapter.snowflakev2";

    static HashMap<String, Object> configurations = new HashMap<String, Object>();
    static {
    }


    public SnowflakeV2Plugin(){
    		super(UUID.fromString(uuid), ADAPTER_ID, configurations);
    }


}