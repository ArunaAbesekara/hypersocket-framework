/*******************************************************************************
 * Copyright (c) 2013 Hypersocket Limited.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/
package com.hypersocket.realm;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hypersocket.properties.PropertyCategory;
import com.hypersocket.properties.ResourceTemplateRepository;
import com.hypersocket.resource.ResourceChangeException;
import com.hypersocket.resource.ResourceCreationException;
import com.hypersocket.tables.ColumnSort;

public interface RealmProvider extends ResourceTemplateRepository {

	void testConnection(Map<String, String> properties, boolean createMode) throws IOException;

	List<Principal> allPrincipals(Realm realm, PrincipalType... types);

	Principal getPrincipalByName(String principalName, Realm realm,
			PrincipalType... acceptTypes);

	boolean verifyPassword(Principal principal, char[] password);

	boolean isReadOnly(Realm realm);

	boolean supportsAccountUnlock(Realm realm);

	Principal createUser(Realm realm, String username,
			Map<String, String> properties, List<Principal> principals,
			String password, boolean forceChange)
			throws ResourceCreationException;

	Principal updateUser(Realm realm, Principal user, String username,
			Map<String, String> properties, List<Principal> principals)
			throws ResourceChangeException;

	void setPassword(Principal principal, String password,
			boolean forceChangeAtNextLogon) throws ResourceCreationException;

	void setPassword(Principal principal, char[] password,
			boolean forceChangeAtNextLogon) throws ResourceCreationException;

	boolean requiresPasswordChange(Principal principal);

	Principal getPrincipalById(Long id, Realm realm, PrincipalType[] type);

	Principal createGroup(Realm realm, String name, List<Principal> principals)
			throws ResourceCreationException;

	Principal createGroup(Realm realm, String name)
			throws ResourceCreationException;

	void deleteGroup(Principal group) throws ResourceChangeException;

	Principal updateGroup(Realm realm, Principal group, String name,
			List<Principal> principals) throws ResourceChangeException;

	void deleteUser(Principal user) throws ResourceChangeException;

	void deleteRealm(Realm realm) throws ResourceChangeException;

	List<Principal> getAssociatedPrincipals(Principal principal);

	String getModule();

	String getResourceBundle();

	List<Principal> getAssociatedPrincipals(Principal principal,
			PrincipalType type);

	Long getPrincipalCount(Realm realm, PrincipalType type, String searchPattern);

	List<?> getPrincipals(Realm realm, PrincipalType type,
			String searchPattern, int start, int length, ColumnSort[] sorting);

	Collection<PropertyCategory> getUserProperties(Principal principal);

	Collection<PropertyCategory> getRealmProperties(Realm realm);

	Collection<PropertyCategory> getGroupProperties(Principal principal);

	String getAddress(Principal principal, MediaType type)
			throws MediaNotFoundException;

	String getPrincipalDescription(Principal principal);

	boolean supportsAccountDisable(Realm realm);

	Principal disableAccount(Principal principal)
			throws ResourceChangeException;

	Principal enableAccount(Principal principal) throws ResourceChangeException;

	Principal unlockAccount(Principal principal) throws ResourceChangeException;

	Set<String> getUserPropertyNames();

	String getUserPropertyValue(Principal principal, String name);
	
	Set<String> getGroupPropertyNames();

	void changePassword(Principal principal, char[] charArray, char[] charArray2)
			throws ResourceChangeException, ResourceCreationException;

	Set<String> getUserVariableNames();
}
