import { checkIsSelected } from "./helpers";
import ProductCard from "./ProductCard";
import { Product } from "./types";

type Props = {
    products : Product[];
    onSelectProduct: (product: Product) => void;
    selectedProducts: Product[]
}


function ProductList({ products, onSelectProduct, selectedProducts}: Props){
    return(
        <div className="orders-list-container">
            <div className="orders-list-items">
                {
                    products.map(prod => <ProductCard 
                        key={prod.id}
                        product={prod}
                        isSelected={checkIsSelected(selectedProducts, prod)} 
                        onSelectProduct={onSelectProduct}
                        />)
                }
            </div>
        </div>

    )
}

export default ProductList;