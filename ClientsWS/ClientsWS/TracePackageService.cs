using NHibernate;
using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ClientsWS
{
    public class TracePackageService
    {
        public TracePackageService()
        {

        }

        public List<TracePackage> getAllPackages(String username)
        {
            ISessionFactory factory = new NHibernate.Cfg.Configuration().Configure().BuildSessionFactory();
            List<TracePackage> packages;

            using (ISession session = factory.OpenSession())
            {
                packages = (List<TracePackage>)session.QueryOver<TracePackage>().Where(x => x.sender == username || x.receiver == username).List();
                session.Close();
            }
            factory.Close();
            return packages;
        }

        public List<TracePackage> searchPackages(String packagename)
        {
            ISessionFactory factory = new NHibernate.Cfg.Configuration().Configure().BuildSessionFactory();
            List<TracePackage> packages;

            using (ISession session = factory.OpenSession())
            {
                packages = (List<TracePackage>)session.QueryOver<TracePackage>().Where(x => x.name == packagename).List();
                session.Close();
            }
            factory.Close();
            return packages;
        }

        public String checkPackageStatus(String packagename)
        {
            ISessionFactory factory = new NHibernate.Cfg.Configuration().Configure().BuildSessionFactory();
            List<TracePackage> packages;

            using (ISession session = factory.OpenSession())
            {
                packages = (List<TracePackage>)session.QueryOver<TracePackage>().Where(x => x.name == packagename).List();
                session.Close();
            }
            factory.Close();
            return packages[0].currentCity;   
        }
    }
}