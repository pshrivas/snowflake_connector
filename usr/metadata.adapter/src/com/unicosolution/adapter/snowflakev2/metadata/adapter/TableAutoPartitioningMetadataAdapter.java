package com.unicosolution.adapter.snowflakev2.metadata.adapter;

import com.informatica.sdk.adapter.metadata.partition.AutoPartitioningMetadataAdapter;
import com.informatica.sdk.adapter.javasdk.common.Logger;
import com.informatica.sdk.adapter.javasdk.common.EStatus;
import com.informatica.sdk.adapter.javasdk.common.ELogLevel;
import com.informatica.sdk.adapter.metadata.aso.semantic.iface.ASOOperation;
import com.informatica.sdk.adapter.metadata.capabilityattribute.semantic.iface.ASOComplexType;
import com.informatica.sdk.adapter.metadata.capabilityattribute.semantic.iface.ReadCapabilityAttributes;
import com.informatica.sdk.adapter.metadata.capabilityattribute.semantic.iface.WriteCapabilityAttributes;
import com.informatica.sdk.adapter.metadata.common.Status;
import com.informatica.sdk.adapter.metadata.common.StatusEnum;
import com.informatica.sdk.adapter.metadata.common.typesystem.typelibrary.semantic.iface.StructuralFeature;
import com.informatica.sdk.adapter.metadata.field.semantic.iface.FieldBase;
import com.informatica.sdk.adapter.metadata.partition.ASOPartitioningScheme;
import com.informatica.sdk.adapter.metadata.partition.AutoPartitioningMetadataAdapter;
import com.informatica.sdk.adapter.metadata.partition.AutoPartitioningMetadataContext;
import com.informatica.sdk.adapter.metadata.partitionscheme.*;
import com.informatica.sdk.adapter.metadata.partitionscheme.semantic.iface.PartitioningSchemeEnum;
import com.informatica.sdk.adapter.metadata.patternblocks.shared.semantic.iface.Record;
import com.informatica.sdk.adapter.metadata.projection.semantic.iface.Projection;
import com.informatica.sdk.adapter.metadata.projection.sourceoperation.semantic.iface.NativeSource;
import com.informatica.sdk.adapter.metadata.provider.Connection;
import com.informatica.sdk.exceptions.SDKException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unused")
public class TableAutoPartitioningMetadataAdapter extends AutoPartitioningMetadataAdapter  {

    private Logger logger = null;

    private ASOOperation asoOp = null;


    		/**
    		 * Initialize the data partition helper.
    		 * 
    		 * @param ctx current partition context
    		 */

    @Override
    public void init(AutoPartitioningMetadataContext ctx) throws SDKException  {
    		//get the ASO Operation to access any capability related information etc.
    	    asoOp = ctx.getAsoOperation();

    	    //get metadata connection attributes to enable connecting to external datasource 
    	    Connection mdConn = ctx.getMetadataConnection();
    	    //retrieve any native partitioning related information
    }



            /**
    	     * Return a list of partitioning schemes the adapter can support
    	     * to read the partitioned data
    	     */

    @Override
    public ASOPartitioningScheme getReadPartitioningScheme() throws SDKException  {
               /* ASOPartitioningScheme sampleReadScheme = new ASOPartitioningScheme();
        	    	//set number of native adapter partitions
        	    	// add adapter specific logic to choose partitioning scheme
        	    	boolean bIsPassthru = false;
        			// retrieve structural features if needed to create expression
        			ASOComplexType cType = asoOp.getComplexTypes().get(0);
        			List<StructuralFeature> strFeatures = cType.getStructuralFeatures();
        			String fldName1 = strFeatures.get(0).getName();
        			String fldName2 = strFeatures.get(1).getName();

        			// retrieve corresponding projection fields used as keys (actual
        			// logic may involve traversing backwards from links appropriately)
        			Projection proj = cType.getProjections().get(0);
        			NativeSource nativeSourceOp = (NativeSource) (proj.getBaseOperations()
        					.get(0));
        			Record nativeRcd = nativeSourceOp.getNativeRecord();
        			FieldBase fldBase1 = nativeRcd.getFieldList().get(0);
        			FieldBase fldBase2 = nativeRcd.getFieldList().get(1);

        			if(bIsPassthru){
        				sampleReadScheme.setSchemeID("sampleReadScheme");
        				PassthroughPartitioning passPart = new PassthroughPartitioning();
        				sampleReadScheme.setNumberOfPartitions(1);
        				sampleReadScheme.setScheme(passPart);
        			}else{
        			    // provide a unique name to identify the scheme
        			    // number of partitions can be fetched from third party system using connection
        			    sampleReadScheme.setNumberOfPartitions(4);
        	    	    sampleReadScheme.setSchemeID("sampleReadScheme");

        			    //enable key range partitioning if suitable
        			    RangePartitioning rangeP = new RangePartitioning();
        			    sampleReadScheme.setScheme(rangeP);
        			    List<PartitioningKey> partitioningKeys = new ArrayList<PartitioningKey>();
        			    PartitioningKey key1 = new PartitioningKey();
        			    PartitioningKey key2 = new PartitioningKey();
        			    //set field1 as base field for this key
        			    key1.setKey(fldBase1);

        			    //PartitioningKey key2 = new PartitioningKey();
        			    //set field1 as base field for this key
        			    key2.setKey(fldBase2);

        			    //add above keys to the list
        			    partitioningKeys.add(key1);
        			    partitioningKeys.add(key2);
        			    rangeP.setPartitioningKeys(partitioningKeys);

        			    List<PartitioningKeyRanges> rangesOfAllKeys = new ArrayList<PartitioningKeyRanges>();
                        // range shall be defined in such a manner that full data set is covered and no partition overlap
        			    //create ranges for key1
        			    PartitioningKeyRanges range1 = new PartitioningKeyRanges();
        			    range1.setPartitioningKey(key1);
        			    //range type is 'right open' for all ranges for current key i.e [a..b) - {x | a <= x < b} 
        			    RangeTypeEnum rangeType = RangeTypeEnum.rightOpen;
        			    range1.setRangeType(rangeType);
                        // empty string in start range is equivalent to -infinity
        			    //provide 4 start ranges as there are 4 partitions. The first range is ignored at runtime though
        			    String[] startR = {"", "20" , "30", ""};
        			    List<String> startRanges = Arrays.asList(startR); 
        			    range1.setStartRanges(startRanges);
                        // empty string in end range is equivalent to infinity
        			    //provide 4 end ranges as there are 4 partitions. The last range is ignored at runtime though
        			    String[] endR = {"20", "30" , "", ""};
        			    List<String> endRanges = Arrays.asList(endR); 
        			    range1.setEndRanges(endRanges);

        			    //create ranges for key2
        			    PartitioningKeyRanges range2 = new PartitioningKeyRanges();
        			    range2.setPartitioningKey(key2);
        			    //range type is 'right open' for all ranges for current key i.e [a..b) - {x | a <= x < b} 
        			    range2.setRangeType(rangeType);

        			   //provide 4 start ranges as there are 4 partitions. The first range is ignored at runtime though
        			   String[] startR2 = {"", "" , "", "200"};
        			   List<String> startRanges2 = Arrays.asList(startR2); 
        			   range2.setStartRanges(startRanges2);

        			   //provide 4 end ranges as there are 4 partitions. The last range is ignored at runtime though
        			   String[] endR2 = {"200", "200" , "200", ""};
        			   List<String> endRanges2 = Arrays.asList(endR2); 
        			   range2.setEndRanges(endRanges2);

        			   //add above ranges to the list
        			   rangesOfAllKeys.add(range1);
        			  rangesOfAllKeys.add(range2);
        			  rangeP.setRangesOfAllKeys(rangesOfAllKeys);
        		   }

        	    	return sampleReadScheme;*/

    	    	return null;
    }



           /**
    	     * Return a list of partitioning schemes the adapter can support
    	     * to write the partitioned data
    	     */

    @Override
    public ASOPartitioningScheme getWritePartitioningScheme() throws SDKException  {
                /* List<ASOPartitioningScheme> schemeList = new ArrayList<ASOPartitioningScheme>();
        	    	ASOPartitioningScheme sampleWriteScheme = new ASOPartitioningScheme();
        	    	//set number of native adapter partitions
        	    	//provide a unique name to identify the scheme
        	    	sampleWriteScheme.setSchemeID("sampleWriteScheme");
                    PassthroughPartitioning passPart = new PassthroughPartitioning(); 
        	    	//set arbitrary partitioning scheme as read scheme
        	    	sampleWriteScheme.setScheme(passPart);
        	    	schemeList.add(sampleWriteScheme);
        	    	sampleWriteScheme.setNumberOfPartitions(1);

        	    	return sampleWriteScheme;*/

    	    	return null;
    }



           /**
    	     * Given the runtime partitioning scheme chosen by framework, populate the adapter specific partition information
    	     * in the ASOOperation's ReadPartitionInfo, WritePartitionInfo
    	     * @return status
    	     */

    @Override
    public Status populateReadCapabilityAttributes(ASOOperation asoOperation) throws SDKException  {
               /*
    	    	PartitioningSchemeEnum readSch = asoOp.getReadPartitioningScheme();
    	    	List<ReadCapabilityAttributes> rAttr = asoOp.getReadCapabilityAttributesList();

    	    	//set adapter specific read partitioning info related attributes for each adapter partition
    	    	ReadCapabilityAttributes attr1 = rAttr.get(0);
    	    	DEMOReadCapabilityAttributesExtension readSampleExtn = (DEMOReadCapabilityAttributesExtension)attr1.getExtensions();
    	    	readSampleExtn.setDescription("Demo desc");
    	    	readSampleExtn.setStagingFileSize(100);

    	    	ReadCapabilityAttributes attr2 = rAttr.get(1);
    	    	DEMOReadCapabilityAttributesExtension readSampleExtn1 = (DEMOReadCapabilityAttributesExtension)attr2.getExtensions();
    	    	readSampleExtn1.setDescription("Demo desc");
    	    	readSampleExtn1.setStagingFileSize(100);*/

    	    	return new Status(StatusEnum.SUCCESS, null);
    	    	
    }



           /**
    	     * Given the runtime partitioning scheme chosen by framework, populate the adapter specific partition information
    	     * in the ASOOperation's ReadPartitionInfo, WritePartitionInfo
    	     * @return status
    	     */

    @Override
    public Status populateWriteCapabilityAttributes(ASOOperation asoOperation) throws SDKException  {
               /*
    	    	PartitioningSchemeEnum writeSch = asoOperation.getWritePartitioningScheme();
    	    	List<WriteCapabilityAttributes> wAttr = asoOperation.getWriteCapabilityAttributesList();*/

    	    	return new Status(StatusEnum.SUCCESS, null);
    	    	
    }


}