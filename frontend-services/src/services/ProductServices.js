import axios from 'axios';

export const getAllProduct = () => {
    console.log(process.env.NEXT_PUBLIC_HOST + `/product`);
	return axios.get(`http://localhost:8081/api/products`, {
		headers: {
			Accept: 'application/json',
		},
	});
};

export const getOneProduct = (id) => {
    return axios.get(`http://localhost:8081/api/products/` + id, {
        headers: {
            Accept: 'application/json',
        },
    });
};

export const storeProduct = (product) => {
    console.log(product)
    return axios.post(`http://localhost:8081/api/products`, product, {
        headers: {
            Accept: 'application/json',            
        },
    });
};

export const deleteProduct = (id) => {
    return axios.delete(`http://localhost:8081/api/products/` + id, {
        headers: {
            Accept: 'application/json',            
        },
    });
};

export const updateProduct = (id, product) => {
    return axios.patch(`http://localhost:8081/api/products/` + id, product, {
        headers: {
            Accept: 'application/json',            
        },
    });
};

// export const getAccomodation = (id) => {
// 	return axios.get(process.env.REACT_APP_API_BASE_URL + `/master/sponsorship/penginapan/` + id, {
// 		headers: {
// 			Authorization: `Bearer ${getAccessToken()}`,
// 			Accept: 'application/json',
// 		},
// 	});
// };

// export const createAccomodation = (accomodation) => {
// 	return axios.post(process.env.REACT_APP_API_BASE_URL + `/master/sponsorship/penginapan/`, accomodation, {
// 		headers: {
// 			Authorization: `Bearer ${getAccessToken()}`,
// 			Accept: 'application/json',
// 			'Content-Type': 'multipart/form-data',
// 		},
// 	});
// };

// export const updateAccomodation = (id, accomodation) => {
// 	return axios.post(process.env.REACT_APP_API_BASE_URL + `/master/sponsorship/penginapan/` + id, accomodation, {
// 		headers: {
// 			Authorization: `Bearer ${getAccessToken()}`,
// 			Accept: 'application/json',
// 			'Content-Type': 'multipart/form-data',
// 		},
// 	});
// };

// export const deleteAccomodation = (id) => {
// 	return axios.delete(process.env.REACT_APP_API_BASE_URL + `/master/sponsorship/penginapan/` + id, {
// 		headers: {
// 			Authorization: `Bearer ${getAccessToken()}`,
// 			Accept: 'application/json',
// 			'Content-Type': 'application/json',
// 		},
// 	});
// };
