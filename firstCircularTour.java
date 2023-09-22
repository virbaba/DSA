int start = 0, extra = 0, less = 0, n = petrol.length;

		for(int i = 0; i < n; i++){
			extra = extra + petrol[i] - distance[i];

			if(extra < 0){
				start = i + 1;
				// suppose distance is 10 and petrol is 9 kami hogi
				// 9 - 10 = -1 abs(-1) 1 and previous less me add hoga
				less = less + Math.abs(extra);
				extra = 0;
			}
		}

		if(extra - less >= 0)
			return start;
		
		return -1;
