// Author : Bibhu

import com.sap.gateway.ip.core.customdev.util.Message

Message processData(Message message) {
    
    def headers = message.getHeaders();
    
    if(headers.get("CamelHTTPQuery")!= null){

        String[] queries = headers.get("CamelHTTPQuery") .split('&');
        
        def filters = [];
        def entity = getEntity("Order");
        
        for( String query : queries ){
            def filter = query.split('=');
            filters.push(getFilter(entity,filter[0],filter[1]));
        }
        
        message.setProperty("filterCrit", filters.join(" and "));
    }else{
        message.setProperty("filterCrit", "");
    }
    
    return message;
}

String getFilter(def entity, String name, String value){

    def type = entity.get(name);
   
    if(type != null){
        switch(type){
            case "Edm.Int32":
            case "Edm.Decimal":
                return "${name} eq ${value}"
            case "Edm.String":
                return "${name} eq '${value}'"
            case "Edm.DateTime":
                return "${name} eq datetime'${value}'"
            default:
                return value
        }
    }
}

def getEntity(String entity){
    switch(entity){
        case "Order" : 
            return ["OrderID": "Edm.Int32",
                    "CustomerID": "Edm.String",
                    "EmployeeID": "Edm.Int32",
                    "OrderDate": "Edm.DateTime",
                    "RequiredDate": "Edm.DateTime",
                    "ShippedDate": "Edm.DateTime",
                    "ShipVia": "Edm.Int32",
                    "Freight": "Edm.Decimal",
                    "ShipName": "Edm.String",
                    "ShipAddress": "Edm.String",
                    "ShipCity": "Edm.String",
                    "ShipRegion": "Edm.String",
                    "ShipPostalCode": "Edm.String",
                    "ShipCountry": "Edm.String"
                    ];
        default :
            return [:];
    }
}




 