package com.dao;

import com.model.*;

public interface CURDOperations {
	public String insert(ModelTest m);

	public String update(ModelTest m);

	public String delete(ModelTest m);

	public String select(ModelTest m);

}
