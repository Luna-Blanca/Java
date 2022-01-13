package DAY_Vc;

import java.util.ArrayList;
import java.util.Iterator;

public class DBAction {
    public ArrayList<UserDB> userDb;

    public boolean enroll(UserDB db) {
        return userDb.add(db);
    }

    public UserDB search(String name) {
        UserDB db = null;

        for (UserDB i : userDb) {
            if (i.getID().equalsIgnoreCase(name) || i.getUserName().equalsIgnoreCase(name)) {
                db = i;
            }
        }
        return db;
    }

    public boolean update(UserDB user) {
        boolean result = false;
        int idx = -1;
        for (int i = 0; i < userDb.size(); i++) {
            UserDB db = userDb.get(i);
            if (db.getID().equalsIgnoreCase(user.getID()) || db.getUserName().equalsIgnoreCase(user.getUserName())) {
                idx = 1;
            }
        }

        if (idx != -1) {
            userDb.set(idx, user);
            result = true;
        }
        return  result;
    }

    public boolean delete(String name) {
        boolean result = false;

        Iterator<UserDB> ie = userDb.iterator();
        while (ie.hasNext()) {
            UserDB user = ie.next();
            if (user.getUserName().equalsIgnoreCase(name) || user.getCheckID().equalsIgnoreCase(name)) {
                ie.remove();
                result = true;
            }
        }
        return result;
    }
}
