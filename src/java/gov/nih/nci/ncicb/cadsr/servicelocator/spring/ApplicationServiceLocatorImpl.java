package gov.nih.nci.ncicb.cadsr.servicelocator.spring;


import gov.nih.nci.ncicb.cadsr.service.CaDSRQueryService;
import gov.nih.nci.ncicb.cadsr.service.UMLBrowserQueryService;
import gov.nih.nci.ncicb.cadsr.servicelocator.ApplicationServiceLocator;
import gov.nih.nci.ncicb.cadsr.servicelocator.ObjectLocator;
import gov.nih.nci.ncicb.cadsr.servicelocator.ServiceLocatorException;
import gov.nih.nci.ncicb.cadsr.util.UMLBrowserParams;
import gov.nih.nci.system.applicationservice.ApplicationService;
import gov.nih.nci.system.applicationservice.ApplicationServiceProvider;

import javax.sql.DataSource;


public class ApplicationServiceLocatorImpl implements ApplicationServiceLocator {

   private UMLBrowserQueryService queryService = null;
   private ObjectLocator objectLocator= new SpringObjectLocatorImpl();
   private ApplicationService cabioAppService = null;
   
   public ApplicationServiceLocatorImpl() {
   }

   public ApplicationService findCaCoreAPIService() throws ServiceLocatorException {
      if (cabioAppService == null){
        cabioAppService = ApplicationServiceProvider.getRemoteInstance(UMLBrowserParams.getInstance().getCadsrURL());
      }
      return cabioAppService;
   }

   public UMLBrowserQueryService findQuerySerivce() throws ServiceLocatorException {
      if (queryService == null) {
         try {
            Object obj =
               new SpringObjectLocatorImpl().findObject("umlBrowserQueryService");
            queryService = (UMLBrowserQueryService)(obj);
         } catch (Exception e) {
            throw new ServiceLocatorException("Exp while locating query serice",
                                              e);
         }
      }
      return queryService;
   }
   
    public CaDSRQueryService findCaDSRQueryService() throws ServiceLocatorException {
        try {
             CaDSRQueryService caDSRQueryService =
                (CaDSRQueryService)objectLocator.findObject("caDSRQueryService");
             return caDSRQueryService;
          } catch (Exception e) {
             throw new ServiceLocatorException("Exp while locating query serice",
                                               e);
          }
    }   
    



}
