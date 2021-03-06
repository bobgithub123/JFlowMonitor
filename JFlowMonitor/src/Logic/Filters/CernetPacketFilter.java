/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Filters;

import Network.*;
import java.util.List;

/**
 *
 * @author YQ
 */
public class CernetPacketFilter extends AbstractPacketFilter {
    private static CernetPacketFilter cernetPacketFilter = null;
    private static CernetReader cernetReader = null;
    public static void Initialize(String fn){
        if(cernetPacketFilter == null){
            cernetPacketFilter = new CernetPacketFilter();
            cernetReader = new CernetReader(fn);
        }
    }
    public static IPacketFilter Instance(){
        if(cernetPacketFilter == null){
            Initialize("Cernet");
        }
        return cernetPacketFilter;
    }
    private CernetPacketFilter(){
    }
    public boolean check(IPacket packet) {
        boolean isInCernet = false;
        int destAddress = packet.getDestAddress();
        int sourceAddress = packet.getSourceAddress();
        int cernetAddress = 0;
        int cernerMask = 0;
        List<CernetAttribute<String, String>> cernetDataList = cernetReader.getCernetAttribute();
        for (int i = 0; i < cernetDataList.size(); ++i) {
            CernetAttribute<String, String> c = cernetDataList.get(i);
            cernetAddress = ipToInt(c.ip);
            cernerMask = ipToInt(c.mask);
            if ((cernetAddress & cernerMask) == (destAddress & cernerMask) &&
                    (cernetAddress & cernerMask) == (sourceAddress & cernerMask)){
                isInCernet = true;
                break;
            }
        }
        return isInCernet;
    }
}
