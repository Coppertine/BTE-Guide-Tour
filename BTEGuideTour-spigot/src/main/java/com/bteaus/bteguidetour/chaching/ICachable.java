package com.bteaus.bteguidetour.chaching;

import java.io.File;
import java.net.URL;

public interface ICachable {

    /**
     *
     * @return The URL from where the data should be downloaded.
     */
    public URL getURL();


    /**
     *
     * @return The name of the file where the data should be saved.
     */
    public String getFileName();


    /**
     * Called by the cacheManager when the resource as been cached
     *
     * @param f The file which as been saved
     */
    public void cached(File f);

}
