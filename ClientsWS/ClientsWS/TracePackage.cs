using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ClientsWS
{
    public class TracePackage
    {
        public virtual int id { get; set; }
        public virtual String sender { get; set; }
        public virtual String receiver { get; set; }
        public virtual String name { get; set; }
        public virtual String description { get; set; }
        public virtual String senderCity { get; set; }
        public virtual String destinationCity { get; set; }
        public virtual String tracking { get; set; }
        public virtual String currentCity { get; set; }

        public TracePackage()
        {
            
        }
    }
}