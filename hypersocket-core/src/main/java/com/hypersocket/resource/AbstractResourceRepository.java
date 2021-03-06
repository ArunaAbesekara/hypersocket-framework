package com.hypersocket.resource;

import java.util.List;
import java.util.Map;

import com.hypersocket.properties.ResourceTemplateRepository;
import com.hypersocket.realm.Realm;
import com.hypersocket.repository.CriteriaConfiguration;
import com.hypersocket.tables.ColumnSort;

public interface AbstractResourceRepository<T extends Resource> extends ResourceTemplateRepository {

	T getResourceByName(String name, Realm realm);

	T getResourceByName(String name, Realm realm, boolean deleted);

	T getResourceById(Long id);

	void deleteResource(T resource);

	@SuppressWarnings("unchecked") 
	void saveResource(T resource, Map<String,String> properties, TransactionOperation<T>... ops);

	List<T> getResources(Realm realm);

	List<T> search(Realm realm, String searchPattern, int start, int length,
			ColumnSort[] sorting, CriteriaConfiguration... configs);

	long getResourceCount(Realm realm, String searchPattern,
			CriteriaConfiguration... configs);

	long allRealmsResourcesCount();

}
