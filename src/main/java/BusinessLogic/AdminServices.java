package BusinessLogic;

import DataLayer.MySQLDbData;
import java.util.*;
import Models.Admin;

public class AdminServices {
    private MySQLDbData adminData;
    
    public AdminServices(){
     this.adminData = new MySQLDbData();
    }
    
    public boolean VerifyAdmin(String userID, String userPassword) {
        List<Admin> admins = adminData.getAdmin();
        boolean result = false;
        for (Admin admin : admins) {
            if (admin.userID.equals(userID) && admin.userPassword.equals(userPassword)) {
                result = true;
                return result;
            }
        }
        return result;
    }
}
