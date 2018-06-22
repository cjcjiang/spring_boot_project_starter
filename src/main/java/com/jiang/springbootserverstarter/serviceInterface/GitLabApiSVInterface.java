package com.jiang.springbootserverstarter.serviceInterface;

import java.io.IOException;

public interface GitLabApiSVInterface {
	
	/** 
     * 调用gitlab api，获得此repo所有文件的压缩包。
     * 
     * @param repoId 需要获得的项目在gitlab中的id。
     * 
     * @param branch 用户需要的此项目的branch。
     * 
     * @throws IOException
     * 
     * @author Yuming Jiang
     * @since 0.0.1-SNAPSHOT
     */
	void getRepoBranchArchive(Integer repoId, String branch) throws IOException;

}
