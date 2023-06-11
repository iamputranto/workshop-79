import Link from "next/link";
import "./globals.css";
import { Inter } from "next/font/google";

const inter = Inter({ subsets: ["latin"] });

export default function RootLayout({ children }) {
  return (
    <html lang="en">
      <body>
        <div>
          <nav className="bg-gray-800 py-4">
            <div className="container mx-auto px-4">
              <div className="flex justify-between items-center">
                <Link href="/">
                  <span className="text-white font-bold text-xl">Logo</span>
                </Link>
                <ul className="flex space-x-4">
                  <li>
                    <Link href="/inventory">
                      <span className="text-white hover:text-gray-300">Inventory</span>
                    </Link>
                  </li>
                  <li>
                    <Link href="/product">
                      <span className="text-white hover:text-gray-300">Product</span>
                    </Link>
                  </li>
                  <li>
                    <Link href="/order">
                      <span className="text-white hover:text-gray-300">Order</span>
                    </Link>
                  </li>
                </ul>
              </div>
            </div>
          </nav>
          <main className="container mx-auto px-4 mt-5">{children}</main>
        </div>
      </body>
    </html>
  );
}
