import ProductCard from "./ProductCard";
import { Product } from "./types";

type Props = {
    products : Product[];
}


function ProductList({ products }: Props){
    return(
        <div className="orders-list-container">
            <div className="orders-list-items">
                {
                    products.map(prod => <ProductCard key={prod.id} product={prod} />)
                }
            </div>
        </div>

    )
}

export default ProductList;