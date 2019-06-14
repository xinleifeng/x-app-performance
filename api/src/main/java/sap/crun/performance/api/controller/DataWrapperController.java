package sap.crun.performance.api.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.jdbc.core.namedparam.SqlParameterSource;
//import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataWrapperController {
	// @Autowired
	// JdbcTemplate jdbcTemplate;
	// @Autowired
	// NamedParameterJdbcTemplate npJdbcTemplate;

	private static final Logger log = LoggerFactory.getLogger(DataWrapperController.class);

	@RequestMapping(value = "/single", method = RequestMethod.GET, produces = "text/plain")
	@ResponseBody
	String getSingleRec() {

		StringBuilder builder = new StringBuilder();
		builder.append("Hello World-single");

		return builder.toString();

	}

	// @PostMapping("bpmon")
	// public KeyFigure newKeyFigure(@RequestBody KeyFigure newKeyFigure) {
	// log.info(newKeyFigure.toString());
	// return newKeyFigure;
	// }

	// @PostMapping("bpmon")
	// public void newKeyFigures(@RequestBody KeyFigure[] newKeyFigures) {
	// Arrays.asList(newKeyFigures).forEach(newKeyFigure ->
	// log.info(newKeyFigure.toString()));
	// }

	/*
	 * 
	 * @PostMapping("bpmon") public int[] newKeyFigures(@RequestBody
	 * KeyFigureWrapper newKeyFigureWrapper) { List<KeyFigure> keyFigures =
	 * newKeyFigureWrapper.getKeyFigures(); // @SuppressWarnings("unchecked") //
	 * Map<String, Object>[] batchValues = new
	 * HashMap[newKeyFigureWrapper.getKeyFigures().size()]; // for(int i = 0; i <
	 * newKeyFigureWrapper.getKeyFigures().size(); i++) { // KeyFigure keyFigure =
	 * keyFigures.get(i); // HashMap<String, Object> paramMap = new HashMap<String,
	 * Object>(); // paramMap.put("id", keyFigure.getId()); // paramMap.put("name",
	 * keyFigure.getName()); // paramMap.put("value", keyFigure.getValue()); //
	 * paramMap.put("charName_1", keyFigure.getCharName_1()); //
	 * paramMap.put("charValue_1", keyFigure.getCharValue_1()); //
	 * paramMap.put("charName_2", keyFigure.getCharName_2()); //
	 * paramMap.put("charValue_2", keyFigure.getCharValue_2()); //
	 * paramMap.put("charName_3", keyFigure.getCharName_3()); //
	 * paramMap.put("charValue_3", keyFigure.getCharValue_3()); // batchValues[i] =
	 * paramMap; // }
	 * 
	 * SqlParameterSource[] batchValues =
	 * SqlParameterSourceUtils.createBatch(keyFigures.toArray());
	 * newKeyFigureWrapper.getKeyFigures().forEach(newKeyFigure ->
	 * log.info(newKeyFigure.toString()));
	 * jdbcTemplate.execute("TRUNCATE TABLE JP_TEST_KEYFIGURE"); return
	 * npJdbcTemplate.
	 * batchUpdate("INSERT INTO JP_TEST_KEYFIGURE VALUES (:id, :name, :value, :charName_1, :charValue_1, "
	 * + ":charName_2, :charValue_2, :charName_3, :charValue_3)", batchValues); //
	 * parameter names used in SQL statement must match class attributes }
	 * 
	 * @PostMapping("bpmon/v2") public int[] newDataSet(@RequestBody DataSet
	 * newDataSet) { List<KpiDetail> kpiDetails = mapFields(newDataSet);
	 * SqlParameterSource[] batchValues =
	 * SqlParameterSourceUtils.createBatch(kpiDetails.toArray());
	 * jdbcTemplate.execute("TRUNCATE TABLE JP_TEST_KPIDETAIL"); return
	 * npJdbcTemplate.
	 * batchUpdate("INSERT INTO JP_TEST_KPIDETAIL VALUES (:id, :timestamp, :charValue_1, :charValue_2, "
	 * +
	 * ":charValue_3, :charValue_4, :charValue_5, :charValue_6, :charValue_7, :charValue_8, :charValue_9, "
	 * + ":charValue_10)", batchValues); }
	 * 
	 * @PostMapping("bpmon/v3") public int[] receive(@RequestBody DataSetv3
	 * newDataSet) { List<KpiDetail> kpiDetails = mapFieldsv3(newDataSet);
	 * SqlParameterSource[] batchValues =
	 * SqlParameterSourceUtils.createBatch(kpiDetails.toArray());
	 * jdbcTemplate.execute("TRUNCATE TABLE JP_TEST_KPIDETAIL"); npJdbcTemplate.
	 * batchUpdate("INSERT INTO JP_TEST_KPIDETAIL VALUES (:keyFigureId, :collId, :timestamp, :charValue_1, "
	 * +
	 * ":charValue_2, :charValue_3, :charValue_4, :charValue_5, :charValue_6, :charValue_7, :charValue_8, :charValue_9, "
	 * + ":charValue_10)", batchValues);
	 * 
	 * // String[] charNames = new String[10]; // String keyFigureID =
	 * newDataSet.getDataSet().getKeyFigureID(); // String collID = ""; // if
	 * (!kpiDetails.isEmpty()) { // collID = kpiDetails.get(0).getCollID(); // } //
	 * jdbcTemplate.query( //
	 * "SELECT charName, sequenceNumber FROM JP_TEST_KPICHARNAME WHERE keyFigureID = ? AND is_ctx_param = ? ORDER BY sequenceNumber"
	 * , new Object[] { keyFigureID, "X" }, // (rs, rowNum) ->
	 * charNames[rs.getInt("sequenceNumber") - 1] = rs.getString("charName") // );
	 * // // String fieldList =
	 * Arrays.asList(charNames).stream().collect(Collectors.joining(", ")); //
	 * List<Object[]> keyFigures = jdbcTemplate.query( // "SELECT " + fieldList +
	 * ", COUNT(*) AS value" +
	 * " FROM JP_TEST_KPIDETAIL WHERE :keyFigureID = ? and :collID = ? " // +
	 * "GROUP BY " + fieldList, new Object[] { keyFigureID, collID }, // (rs,
	 * rowNum) -> new Object[]{ rs.getString("value") } // );
	 * 
	 * return null; }
	 * 
	 * @PostMapping("bpmon/v4") public int[] receiveV4(@RequestBody DataSetv3
	 * newDataSet) { List<KpiDetail> kpiDetails = mapFieldsV4(newDataSet);
	 * SqlParameterSource[] batchValues =
	 * SqlParameterSourceUtils.createBatch(kpiDetails.toArray());
	 * jdbcTemplate.execute("TRUNCATE TABLE CRUN_BM_KPIDETAIL"); // npJdbcTemplate.
	 * batchUpdate("INSERT INTO JP_TEST_KPIDETAIL VALUES (:keyFigureId, :collId, :timestamp, :charValue_1, "
	 * // +
	 * ":charValue_2, :charValue_3, :charValue_4, :charValue_5, :charValue_6, :charValue_7, :charValue_8, :charValue_9, "
	 * // + ":charValue_10)", batchValues); npJdbcTemplate.
	 * batchUpdate("INSERT INTO CRUN_BM_KPIDETAIL VALUES (:lmsId, :kpiId, :variantId ,:saveTimestamp, :collId, :timestamp, "
	 * +
	 * ":charValue_1, :charValue_2, :charValue_3, :charValue_4, :charValue_5, :charValue_6, :charValue_7, :charValue_8, "
	 * + ":charValue_9, :charValue_10)", batchValues);
	 * 
	 * String keyFigureId = newDataSet.getDataSet().getKeyFigureId(); String collID
	 * = ""; if (!kpiDetails.isEmpty()) { collID = kpiDetails.get(0).getCollId(); }
	 * Map<String, FieldInfo> fieldMapping = new HashMap<String, FieldInfo>(); //
	 * jdbcTemplate.query( // "SELECT source, target, index " + //
	 * "FROM JP_TEST_KPIGROUPBYFIELDMAP AS t1 " + //
	 * "LEFT OUTER JOIN JP_TEST_KPICHARACTERISTIC AS t2 " + //
	 * "  ON t1.kpiId  = t2.keyFigureId " + // " AND t1.source = t2.charId " + //
	 * "WHERE kpiId = ?", new Object[] { keyFigureID }, // (rs, rowNum) ->
	 * fieldMapping.put(rs.getString("source"), // new
	 * FieldInfo(rs.getString("source"), rs.getString("target"), null, null,
	 * rs.getInt("index")) // )); jdbcTemplate.query(
	 * "SELECT source, targetKpiDetail, targetKpiHistory FROM CRUN_BM_KPICHARMAP WHERE kpiId = ?"
	 * , new Object[] { keyFigureId }, (rs, rowNum) ->
	 * fieldMapping.put(rs.getString("source"), new
	 * FieldInfo(rs.getString("source"), rs.getInt("targetKpiDetail"),
	 * rs.getInt("targetKpiHistory"), null, null, null) ));
	 * 
	 * 
	 * Map<String, FieldInfo> aggrFuncMapping = new HashMap<String, FieldInfo>();
	 * jdbcTemplate.query(
	 * "SELECT source, target, aggrFunc, unitChar FROM CRUN_BM_KPIAGGRFUNC WHERE kpiId = ?"
	 * , new Object[] { keyFigureId }, (rs, rowNum) ->
	 * aggrFuncMapping.put(rs.getString("source"), new
	 * FieldInfo(rs.getString("source"), 0, 0, rs.getString("target"),
	 * rs.getString("aggrFunc"), rs.getString("unitChar")) ));
	 * 
	 * StringBuilder sbFieldList = new StringBuilder(); for (FieldInfo fieldInfo:
	 * fieldMapping.values()) { if (fieldInfo.getTargetKpiHistory() > 0) {
	 * sbFieldList.append("CHARVALUE_").append(fieldInfo.getTargetKpiHistory()).
	 * append(','); } }
	 * 
	 * String aggrFunc; String srcField; StringBuilder sbAggrFunc = new
	 * StringBuilder(); for (FieldInfo fieldInfo: aggrFuncMapping.values()) { if
	 * (fieldInfo.getAggrFunc().equals("ROWCOUNT")) { aggrFunc = "COUNT"; srcField =
	 * "*"; } else { aggrFunc = fieldInfo.getAggrFunc(); srcField =
	 * fieldInfo.getSource(); }
	 * sbAggrFunc.append(aggrFunc).append('(').append(srcField).append(") AS ").
	 * append(fieldInfo.getKeyfName()).append(',');
	 * 
	 * if (!fieldInfo.getUnitChar().isEmpty()) { int targetKpiDetail =
	 * fieldMapping.get(fieldInfo.getUnitChar()).getTargetKpiDetail();
	 * sbFieldList.append("CHARVALUE_").append(targetKpiDetail).append(','); } }
	 * 
	 * if (sbFieldList.length() > 0) { // delete trailing comma
	 * sbFieldList.deleteCharAt(sbFieldList.length() - 1); }
	 * 
	 * String groupBy = sbFieldList.toString();
	 * 
	 * if (sbAggrFunc.length() > 0) {
	 * sbFieldList.append(',').append(sbAggrFunc).deleteCharAt(sbFieldList.length()
	 * - 1); }
	 * 
	 * String sqlStmt = "SELECT " + sbFieldList.toString() +
	 * " FROM CRUN_BM_KPIDETAIL WHERE keyFigureId = ? AND collId = ? GROUP BY " +
	 * groupBy; System.out.println(sqlStmt);
	 * 
	 * List<Object[]> keyFigures = jdbcTemplate.query(sqlStmt, new Object[] {
	 * keyFigureId, collID }, (rs, rowNum) -> { int colCount =
	 * rs.getMetaData().getColumnCount(); Object[] row = new Object[colCount]; for
	 * (int i = 0; i < colCount; i++ ) { row[i] = rs.getObject(i+1); } return row; }
	 * );
	 * 
	 * return null; }
	 * 
	 * private List<KpiDetail> mapFieldsV4(DataSetv3 dataSet) { List<KpiDetail>
	 * kpiDetails = new ArrayList<KpiDetail>(); String[] charNames = new
	 * String[100]; String keyFigureId = dataSet.getDataSet().getKeyFigureId();
	 * jdbcTemplate.query( //
	 * "SELECT source, targetKpiDetail, targetKpiHistory FROM JP_TEST_KPICHARMAP WHERE kpiId = ? ORDER BY targetKpiDetail"
	 * , new Object[] { keyFigureId }, // (rs, rowNum) -> charNames[rowNum] =
	 * rs.getString("source")
	 * "SELECT source, targetKpiDetail, targetKpiHistory FROM CRUN_BM_KPICHARMAP WHERE kpiId = ?"
	 * , new Object[] { keyFigureId }, (rs, rowNum) ->
	 * charNames[rs.getInt("targetKpiDetail")] = rs.getString("source") );
	 * 
	 * int[] permutation = new int[100]; for (int i = 0; i < permutation.length;
	 * i++) { permutation[i] = -1; } String[] header =
	 * dataSet.getDataSet().getHeader(); for (int i = 0; i < charNames.length; i++)
	 * { for (int j = 0; j < header.length; j++ ) { if (charNames[i] != null &&
	 * charNames[i].equals(header[j])) { permutation[i] = j; // data field j shall
	 * be mapped to characteristic i } } }
	 * 
	 * String collId = UUID.randomUUID().toString(); DateFormat df = new
	 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); String timestamp = df.format(new
	 * Date());
	 * 
	 * for (String[] str: dataSet.getDataSet().getData()) { // permute(str,
	 * permutation); KpiDetail kpiDetail = new KpiDetail(keyFigureId, collId,
	 * timestamp, str, permutation); kpiDetails.add(kpiDetail); }
	 * 
	 * return kpiDetails; }
	 * 
	 * private List<KpiDetail> mapFieldsv3(DataSetv3 dataSet) { List<KpiDetail>
	 * kpiDetails = new ArrayList<KpiDetail>(); String[] charNames = new String[10];
	 * String keyFigureId = dataSet.getDataSet().getKeyFigureId();
	 * jdbcTemplate.query(
	 * "SELECT charName FROM JP_TEST_KPICHARNAME WHERE keyFigureId = ? ORDER BY sequenceNumber"
	 * , new Object[] { keyFigureId }, (rs, rowNum) -> charNames[rowNum] =
	 * rs.getString("charName") );
	 * 
	 * int[] permutation = new int[10]; for (int i = 0; i < permutation.length; i++)
	 * { permutation[i] = -1; } String[] header = dataSet.getDataSet().getHeader();
	 * for (int i = 0; i < charNames.length; i++) { for (int j = 0; j <
	 * header.length; j++ ) { if (charNames[i].equals(header[j])) { permutation[i] =
	 * j; // data field j shall be mapped to characteristic i } } }
	 * 
	 * String collId = UUID.randomUUID().toString(); DateFormat df = new
	 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); String timestamp = df.format(new
	 * Date());
	 * 
	 * for (String[] str: dataSet.getDataSet().getData()) { // permute(str,
	 * permutation); KpiDetail kpiDetail = new KpiDetail(keyFigureId, collId,
	 * timestamp, str, permutation); kpiDetails.add(kpiDetail); }
	 * 
	 * return kpiDetails; }
	 * 
	 * // private void permute(String[] str, int[] permutation) { // // }
	 * 
	 * private List<KpiDetail> mapFields(DataSet dataSet) { List<KpiDetail>
	 * kpiDetails = new ArrayList<KpiDetail>(); List<KpiParam> kpiParams =
	 * jdbcTemplate.query(
	 * "SELECT id, charName, sequenceNumber FROM JP_TEST_KPICHARNAME WHERE id = ? ORDER BY sequenceNumber"
	 * , new Object[] { "4711" }, (rs, rowNum) -> new KpiParam(rs.getString("id"),
	 * rs.getString("charName"), rs.getInt("sequenceNumber")) );
	 * 
	 * Map<String, Integer> kpiParamMap = new HashMap<String, Integer>(); for
	 * (KpiParam kpiParam: kpiParams) { kpiParamMap.put(kpiParam.getCharName(),
	 * kpiParam.getSequenceNumber()); }
	 * 
	 * Header header = dataSet.getDataSet().getHeader(); for (Data record:
	 * dataSet.getDataSet().getData()) { String[] str = record.toArray(kpiParamMap,
	 * header); KpiDetail kpiDetail = new KpiDetail(str); kpiDetails.add(kpiDetail);
	 * }
	 * 
	 * return kpiDetails; }
	 * 
	 */
}