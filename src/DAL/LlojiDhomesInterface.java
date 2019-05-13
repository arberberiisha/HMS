package DAL;

import BLL.LlojiDhomes;
import java.util.List;


public interface LlojiDhomesInterface {
    void create(LlojiDhomes en) throws ProjectException;
    void edit(LlojiDhomes en) throws ProjectException;
    void delete(LlojiDhomes en) throws ProjectException;
    List<LlojiDhomes> findAll() throws ProjectException;
    LlojiDhomes findByID(Integer ID) throws ProjectException;
}
