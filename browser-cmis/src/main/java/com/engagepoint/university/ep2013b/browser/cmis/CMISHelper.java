package com.engagepoint.university.ep2013b.browser.cmis;

import com.engagepoint.university.ep2013b.browser.api.BrowserItem;
import com.engagepoint.university.ep2013b.browser.api.BrowserService;
import org.apache.chemistry.opencmis.client.api.*;
import org.apache.chemistry.opencmis.client.runtime.SessionFactoryImpl;
import org.apache.chemistry.opencmis.commons.SessionParameter;
import org.apache.chemistry.opencmis.commons.enums.BindingType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CMISHelper implements BrowserService
{
    // Unique Service Provider name
    private static final String SERVICE_NAME = "CMIS";

    // Should return SERVICE_NAME
    @Override
    public String getServiceName()
    {
        return SERVICE_NAME;
    }

    public List<BrowserItem> getRootFolder()
    {
        Folder root = connect().getRootFolder();
        ItemIterable<CmisObject> children = root.getChildren();

        List<BrowserItem> list = new ArrayList<BrowserItem>();

        BrowserItem item;

        for (CmisObject o : children)
        {
            item = new BrowserItem();
            item.setName(o.getName());
            item.setType((o instanceof Folder) ? BrowserItem.TYPE.FOLDER: BrowserItem.TYPE.FILE);

            list.add(item);
        }

        return list;
    }

    public Session connect()
    {
        SessionFactory sessionFactory = SessionFactoryImpl.newInstance();
        Map<String, String> parameter = new HashMap<String, String>();

        // WSDL
        final String url = "http://localhost:8080/server/services/";
        parameter.put(SessionParameter.BINDING_TYPE, BindingType.WEBSERVICES.value());
        parameter.put(SessionParameter.WEBSERVICES_ACL_SERVICE,             url+"ACLService?wsdl");
        parameter.put(SessionParameter.WEBSERVICES_DISCOVERY_SERVICE,       url+"DiscoveryService?wsdl");
        parameter.put(SessionParameter.WEBSERVICES_MULTIFILING_SERVICE,     url+"MultiFilingService?wsdl");
        parameter.put(SessionParameter.WEBSERVICES_NAVIGATION_SERVICE,      url+"NavigationService?wsdl");
        parameter.put(SessionParameter.WEBSERVICES_OBJECT_SERVICE,          url+"ObjectService?wsdl");
        parameter.put(SessionParameter.WEBSERVICES_POLICY_SERVICE,          url+"PolicyService?wsdl");
        parameter.put(SessionParameter.WEBSERVICES_RELATIONSHIP_SERVICE,    url+"RelationshipService?wsdl");
        parameter.put(SessionParameter.WEBSERVICES_REPOSITORY_SERVICE,      url+"RepositoryService?wsdl");
        parameter.put(SessionParameter.WEBSERVICES_VERSIONING_SERVICE,      url+"VersioningService?wsdl");

        Repository repository = sessionFactory.getRepositories(parameter).get(0);
        parameter.put(SessionParameter.REPOSITORY_ID, repository.getId());

        return sessionFactory.createSession(parameter);
    }
}