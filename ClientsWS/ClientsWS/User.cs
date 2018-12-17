using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ClientsWS
{
    public class User
    {
        public virtual String Username { get; set; }
        public virtual String Password { get; set; }
        public virtual String Role { get; set; }

        public User()
        {

        }
    }
}