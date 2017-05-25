package com.prodapt.app.dao;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
@FunctionalInterface
public interface AppDao {

	public List<String[]> getResult(String appname) throws IOException;
}
