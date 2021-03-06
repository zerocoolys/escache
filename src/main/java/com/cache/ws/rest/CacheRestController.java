package com.cache.ws.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cache.ws.constant.GaConstant;
import com.cache.ws.es.dto.IndicatorData;
import com.cache.ws.es.service.EsQueryService;
import com.cache.ws.mongo.MongoDBOperate;
import com.cache.ws.mongo.MongoDBSummaryHandle;
import com.cache.ws.mongo.dto.ResultData;
import com.cache.ws.rest.dto.RestPraram;
import com.cache.ws.util.CacheUtils;
import com.mongodb.DBObject;

@Controller
@Path("/loading")
public class CacheRestController {
	@Autowired
	private MongoDBOperate operate;

	@Autowired
	private EsQueryService esService;

	@GET
	@Path("/condition/{redisKey}/{types}/{start}/{end}")
	@Produces("application/json")
	public List<ResultData> loadCacheData(
			@PathParam("redisKey") String redisKey,
			@PathParam("types") String types, @PathParam("start") Long start,
			@PathParam("end") Long end) {
		List<ResultData> resultData = new ArrayList<ResultData>();
		String[] indexes = null;
		try {
			indexes = CacheUtils.createIndexes(start, end, "access-");
			RestPraram rp = new RestPraram();
			rp.setRedisKey(redisKey);
			rp.setTypes(types);
			rp.setIndexes(indexes);

			for (String index : indexes) {
				// 是否有缓存
				if (!operate.isMongoDataExist("",index, rp.getRedisKey())) {

					List<IndicatorData> data = esService.queryDataindexTable(
							rp.getRedisKey(), index, rp.getTypes());

					operate.insertMongoData(data, index, rp.getRedisKey());
				}
			}

			// 查询
			List<DBObject> temp = operate.query(GaConstant.DB_NAME,rp.getIndexes(),
					rp.getRedisKey());

			resultData = new MongoDBSummaryHandle().handle(temp, null);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultData;
	}

	@GET
	@Path("/summaryCondition/{redisKey}/{types}/{start}/{end}")
	@Produces("application/json")
	public List<ResultData> loadSummaryCacheData(
			@PathParam("redisKey") String redisKey,
			@PathParam("types") String types, @PathParam("start") Long start,
			@PathParam("end") Long end) {

		List<ResultData> resultData = new ArrayList<ResultData>();
		String[] indexes = null;
		try {
			indexes = CacheUtils.createIndexes(start, end, "access-");
			RestPraram rp = new RestPraram();
			rp.setRedisKey(redisKey);
			rp.setTypes(types);
			rp.setIndexes(indexes);

			for (String index : indexes) {
				// 是否有缓存
				if (!operate.isMongoDataExist("",index, rp.getRedisKey())) {

					List<IndicatorData> data = esService.queryDataindexTable(
							rp.getRedisKey(), index, rp.getTypes());

					operate.insertMongoData(data, index, rp.getRedisKey());
				}
			}

			// 查询
			List<DBObject> temp = operate.query(GaConstant.DB_NAME,rp.getIndexes(),
					rp.getRedisKey());

			resultData = new MongoDBSummaryHandle().handle(temp, null);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultData;
	}

}
