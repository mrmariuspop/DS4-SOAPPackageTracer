using NHibernate;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ClientsWS
{
    public class UserService
    {
        public UserService()
        {

        }

        public String login(String Username, String Password)
        {
            ISessionFactory factory = new NHibernate.Cfg.Configuration().Configure().BuildSessionFactory();
            using (ISession session = factory.OpenSession())
            {
                User user = (User)session.Get<User>(Username);
                if (user != null)
                {
                    if (user.Password.Equals(Password))
                    {
                        return user.Role;
                    }
                    else
                    {
                        return "fail";
                    }
                }
                session.Close();
            }
            factory.Close();
            return "fail";
        }

        public void register(String Username, String Password)
        {
            User user = new User();
            user.Username = Username;
            user.Password = Password;
            user.Role = "user";

            ISessionFactory factory = new NHibernate.Cfg.Configuration().Configure().BuildSessionFactory();
            using (ISession session = factory.OpenSession())
            {
                using (ITransaction transaction = session.BeginTransaction())
                {
                    session.Save(user);
                    transaction.Commit();
                }
                session.Close();
            }
            factory.Close();
        }
    }
}