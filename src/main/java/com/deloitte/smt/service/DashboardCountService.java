package com.deloitte.smt.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class DashboardCountService {

	@PersistenceContext
	private EntityManager entityManager;
	
	private String ownerQuery = "( S.OWNER IS NULL OR S.OWNER IN (?)";
	private String userKeyQuery = " OR A.USER_KEY IN (";
	private String userGroupKeyQuery = " OR A.USER_GROUP_KEY IN (";

	@SuppressWarnings("unchecked")
	public Long getValidateAndPrioritizeCount(String owner, List<String> userKeys, List<String> userGroupKeys) {
		Long count = 0l;
		StringBuilder queryBuilder = new StringBuilder("SELECT DISTINCT S.* FROM SM_TOPIC S LEFT JOIN SM_TOPIC_SIGNAL_VALIDATION_ASSIGNEES A ON A.TOPIC_ID = S.ID WHERE ");
		queryBuilder.append(ownerQuery);
		StringBuilder keyBuilder;
		String userKey;
		if(!CollectionUtils.isEmpty(userKeys)){
			queryBuilder.append(userKeyQuery);
			keyBuilder = new StringBuilder();
			for(String key:userKeys){
				keyBuilder.append("'");
				keyBuilder.append(key);
				keyBuilder.append("'");
				keyBuilder.append(",");
			}
			userKey = keyBuilder.toString().substring(0, keyBuilder.lastIndexOf(","));
			queryBuilder.append(userKey);
			queryBuilder.append(")");
		}
		StringBuilder groupKeyBuilder;
		String groupKey;
		if(!CollectionUtils.isEmpty(userGroupKeys)){
			queryBuilder.append(userGroupKeyQuery);
			groupKeyBuilder = new StringBuilder();
			for(String key:userGroupKeys){
				groupKeyBuilder.append("'");
				groupKeyBuilder.append(key);
				groupKeyBuilder.append("'");
				groupKeyBuilder.append(",");
			}
			groupKey = groupKeyBuilder.toString().substring(0, groupKeyBuilder.lastIndexOf(","));
			queryBuilder.append(groupKey);
			queryBuilder.append(")");
		}
		
		queryBuilder.append(") AND S.SIGNAL_STATUS <> 'Completed'");
		Query query = entityManager.createNativeQuery(queryBuilder.toString());
		query.setParameter(1, owner);
		List<Object> topicCount = query.getResultList();
		if(topicCount != null){
			Integer size = topicCount.size();
			count = size.longValue();
			
		}
		return count;
	}
	
	@SuppressWarnings("unchecked")
	public Long getAssessmentCount(String owner, List<String> userKeys, List<String> userGroupKeys) {
		Long count = 0l;
		StringBuilder queryBuilder = new StringBuilder("SELECT DISTINCT S.* FROM SM_ASSESSMENT_PLAN S LEFT JOIN SM_TOPIC_ASSESSMENT_ASSIGNMENT_ASSIGNEES A ON A.ASSESSMENT_ID = S.ID WHERE ");
		queryBuilder.append(ownerQuery);
		StringBuilder keyBuilder;
		String userKey;
		if(!CollectionUtils.isEmpty(userKeys)){
			queryBuilder.append(userKeyQuery);
			keyBuilder = new StringBuilder();
			for(String key:userKeys){
				keyBuilder.append("'");
				keyBuilder.append(key);
				keyBuilder.append("'");
				keyBuilder.append(",");
			}
			userKey = keyBuilder.toString().substring(0, keyBuilder.lastIndexOf(","));
			queryBuilder.append(userKey);
			queryBuilder.append(")");
		}
		StringBuilder groupKeyBuilder;
		String groupKey;
		if(!CollectionUtils.isEmpty(userGroupKeys)){
			queryBuilder.append(userGroupKeyQuery);
			groupKeyBuilder = new StringBuilder();
			for(String key:userGroupKeys){
				groupKeyBuilder.append("'");
				groupKeyBuilder.append(key);
				groupKeyBuilder.append("'");
				groupKeyBuilder.append(",");
			}
			groupKey = groupKeyBuilder.toString().substring(0, groupKeyBuilder.lastIndexOf(","));
			queryBuilder.append(groupKey);
			queryBuilder.append(")");
		}
		
		queryBuilder.append(") AND S.ASSESSMENT_PLAN_STATUS <> 'Completed'");
		Query query = entityManager.createNativeQuery(queryBuilder.toString());
		query.setParameter(1, owner);
		List<Object> topicCount = query.getResultList();
		if(topicCount != null){
			Integer size = topicCount.size();
			count = size.longValue();
		}
		return count;
	}
	
	@SuppressWarnings("unchecked")
	public Long getRiskCount(String owner, List<String> userKeys, List<String> userGroupKeys) {
		Long count = 0l;
		StringBuilder queryBuilder = new StringBuilder("SELECT DISTINCT S.* FROM SM_RISK_PLAN S LEFT JOIN SM_TOPIC_RISKPLAN_ASSIGNMENT_ASSIGNEES A ON A.RISK_ID = S.ID WHERE ");
		queryBuilder.append(ownerQuery);
		StringBuilder keyBuilder;
		String userKey;
		if(!CollectionUtils.isEmpty(userKeys)){
			queryBuilder.append(userKeyQuery);
			keyBuilder = new StringBuilder();
			for(String key:userKeys){
				keyBuilder.append("'");
				keyBuilder.append(key);
				keyBuilder.append("'");
				keyBuilder.append(",");
			}
			userKey = keyBuilder.toString().substring(0, keyBuilder.lastIndexOf(","));
			queryBuilder.append(userKey);
			queryBuilder.append(")");
		}
		StringBuilder groupKeyBuilder;
		String groupKey;
		if(!CollectionUtils.isEmpty(userGroupKeys)){
			queryBuilder.append(userGroupKeyQuery);
			groupKeyBuilder = new StringBuilder();
			for(String key:userGroupKeys){
				groupKeyBuilder.append("'");
				groupKeyBuilder.append(key);
				groupKeyBuilder.append("'");
				groupKeyBuilder.append(",");
			}
			groupKey = groupKeyBuilder.toString().substring(0, groupKeyBuilder.lastIndexOf(","));
			queryBuilder.append(groupKey);
			queryBuilder.append(")");
		}
		
		queryBuilder.append(") AND S.STATUS <> 'Completed'");
		Query query = entityManager.createNativeQuery(queryBuilder.toString());
		query.setParameter(1, owner);
		List<Object> topicCount = query.getResultList();
		if(topicCount != null){
			Integer size = topicCount.size();
			count = size.longValue();
		}
		return count;
	}

}
