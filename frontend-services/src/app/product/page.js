"use client"; // This is a client component 👈🏽
import { deleteProduct, getAllProduct } from "@/services/ProductServices";
import Head from "next/head";
import Link from "next/link";
import { useState, useEffect } from 'react';

export default function Product() {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    getAllProduct().then((data) => {
      // console.log(data.data);
      setProducts(data.data);
    });
  }, []);

  const handleDelete = (id) => {
    // console.log(id);
    const confirm = window.confirm("Are you sure delete this product?");
    if (confirm) {
      deleteProduct(id).then((data) => {
        console.log(data);
        getAllProduct().then((data) => {
          // console.log(data.data);
          setProducts(data.data);
        });
      });
    }
  };

  return (
    <div>
      <div className="flex justify-between items-center">
        <h1 className="text-2xl font-bold mb-5">Product Service</h1>

        <Link href="/product/create">
          <button className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded mb-2">
            Create
          </button>
        </Link>
      </div>

      <div className="relative overflow-x-auto">
        <table className="w-full text-sm text-left text-gray-500 dark:text-gray-400">
          <thead className="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
            <tr>
              <th scope="col" className="px-6 py-3">
                #ID
              </th>
              <th scope="col" className="px-6 py-3">
                Name
              </th>
              <th scope="col" className="px-6 py-3">
                Description
              </th>
              <th scope="col" className="px-6 py-3">
                Price
              </th>
              <th>Aksi</th>
            </tr>
          </thead>
          <tbody>
            {products.map((product) => (
              <tr key={product.id} className="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
                <td className="px-6 py-4">{product.id}</td>
                <td className="px-6 py-4">{product.name}</td>
                <td className="px-6 py-4">{product.description}</td>
                <td className="px-6 py-4">{product.price}</td>
                <td>
                  <Link href={`/product/edit/${product.id}`}>
                    <button className="bg-yellow-500 hover:bg-yellow-700 text-white font-bold py-2 px-4 mr-3 rounded">
                      Edit
                    </button>
                  </Link>
                  <button className="bg-red-500 hover:bg-red-700 text-white font-bold py-2 px-4 rounded" onClick={
                    () => handleDelete(product.id)
                  }>
                    Delete
                  </button>
                </td>
              </tr>
            ))}
            {/* <tr className="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
              <td className="px-6 py-4">12433635</td>
              <th
                scope="row"
                className="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white"
              >
                Apple MacBook Pro 17"
              </th>
              <td className="px-6 py-4">Silver</td>
              <td className="px-6 py-4">$2999</td>
              <td>
                <button className="bg-yellow-500 hover:bg-yellow-700 text-white font-bold py-2 px-4 mr-3 rounded">
                  Edit
                </button>
                <button className="bg-red-500 hover:bg-red-700 text-white font-bold py-2 px-4 rounded">
                  Delete
                </button>
              </td>
            </tr> */}
          </tbody>
        </table>
      </div>
    </div>
  );
}
