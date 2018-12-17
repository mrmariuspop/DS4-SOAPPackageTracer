using NHibernate;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace ClientsWS
{
    /// <summary>
    /// Summary description for ClientsWebService
    /// </summary>
    [WebService(Namespace = "http://assignment4ClientsWebService.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    public class ClientsWebService : System.Web.Services.WebService
    {
        private UserService uservice;
        private TracePackageService tpservice;

        public ClientsWebService()
        {
            uservice = new UserService();
            tpservice = new TracePackageService();
        }

        [WebMethod]
        public string loginWS(String Username, String Password)
        {
            return uservice.login(Username, Password);
        }

        [WebMethod]
        public void registerWS(String Username, String Password)
        {
            uservice.register(Username, Password);
        }

        [WebMethod]
        public List<TracePackage> getAllPackagesWS(String Username)
        {
            return tpservice.getAllPackages(Username);
        }

        [WebMethod]
        public List<TracePackage> searchPackagesWS(String Packagename)
        {
            return tpservice.searchPackages(Packagename);
        }

        [WebMethod]
        public String checkPackageStatusWS(String Packagename)
        {
            return tpservice.checkPackageStatus(Packagename);
        }
    }
}
