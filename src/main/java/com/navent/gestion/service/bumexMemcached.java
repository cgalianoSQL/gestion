package com.navent.gestion.service;

public class bumexMemcached {

	public String key;
	public Object value;
	private static bumexMemcached miBumexMemcacheds;



	private bumexMemcached(String key, Object value){	
		this.key=key;
		this.value=value;
	
	}

	public static void set(String key, Object value) {
		if (miBumexMemcacheds==null) {
		
			miBumexMemcacheds = new bumexMemcached( key, value);

		}
		miBumexMemcacheds.key = key;
		miBumexMemcacheds.value = value;

	}


  public String getKey(bumexMemcached miBumexMemcacheds) {
        return key;
    }
	
	public static Object get(String key){
		if (miBumexMemcacheds == null) {
			return null;
		}

		if (key.equals(miBumexMemcacheds.key)) {
			return miBumexMemcacheds.value;
		}

		return null;
	}
	
	public static void delete(String key){
		if (miBumexMemcacheds!=null) {
			if (key.equals(miBumexMemcacheds.key)) {
				miBumexMemcacheds = null;

			}
		}
	}

	
}