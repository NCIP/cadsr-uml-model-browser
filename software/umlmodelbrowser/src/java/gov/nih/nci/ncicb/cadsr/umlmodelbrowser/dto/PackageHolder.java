/*L
 * Copyright Oracle Inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-uml-model-browser/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.umlmodelbrowser.dto;

import java.util.List;
import java.util.Map;

import javax.swing.tree.DefaultMutableTreeNode;

public class PackageHolder
{
   private Map<String,List<DefaultMutableTreeNode>> packagesWithSubProjectsMap;
   private Map<String,List<DefaultMutableTreeNode>> packagesWithNoSubProjectsMap;
    
    public PackageHolder()
    {
    }

    public void setPackagesWithSubProjectsMap(Map<String, List<DefaultMutableTreeNode>> packagesWithSubProjectsMap)
    {
        this.packagesWithSubProjectsMap = packagesWithSubProjectsMap;
    }

    public Map<String, List<DefaultMutableTreeNode>> getPackagesWithSubProjectsMap()
    {
        return packagesWithSubProjectsMap;
    }

    public void setPackagesWithNoSubProjectsMap(Map<String, List<DefaultMutableTreeNode>> packagesWithNoSubProjectsMap)
    {
        this.packagesWithNoSubProjectsMap = packagesWithNoSubProjectsMap;
    }

    public Map<String, List<DefaultMutableTreeNode>> getPackagesWithNoSubProjectsMap()
    {
        return packagesWithNoSubProjectsMap;
    }
}
