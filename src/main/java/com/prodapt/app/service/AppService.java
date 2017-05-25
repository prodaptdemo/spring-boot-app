package com.prodapt.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prodapt.app.dao.AppDao;
import com.prodapt.app.model.AppModel;
import com.prodapt.app.model.AppResponse;

@Component
public class AppService {

	@Autowired
	private AppDao appDao;

	
	
	public void setAppDao(AppDao appDao) {
		this.appDao = appDao;
	}
	
	public AppResponse getResult(String appname) 
	{
		AppResponse response = new AppResponse();
		List<String[]> lstdataStrArr;
		try {
			lstdataStrArr = appDao.getResult(appname);
			if(lstdataStrArr.isEmpty())
			{
				response.setLstresult(null);
				response.setResponseCode("Success");
				response.setResponseMessage("No record found");
			}
			else
			{
				List<AppModel> lstdata = new ArrayList<>();
				response.setResponseCode("Success");
				if(null!=appname &&  !"".equalsIgnoreCase(appname))
				{
					response.setResponseMessage("Records Found for the input:"+appname);
				}
				else
				{
					response.setResponseMessage("Records Found");
				}
				
				for(String[] strarr : lstdataStrArr)
				{
					AppModel model = new AppModel();
					model.setAppid(strarr[0]);
					model.setAppName(strarr[1]);
					model.setStatus(strarr[2]);
					model.setNooftimeinstalled(strarr[3]);
					model.setDataConsumption(strarr[4]);
					model.setUsageFrequency(strarr[5]);
					model.setMemoryUtilised(strarr[6]);
					lstdata.add(model);
							
				}
				response.setLstresult(lstdata);
			}
		} catch (Exception e) {
			response.setLstresult(null);
			response.setResponseCode("Failure");
			response.setResponseMessage("Exception Occured : "+e.getMessage());
			e.printStackTrace();
			
		}
		
		
		
		return response;
	}
	
	
}
