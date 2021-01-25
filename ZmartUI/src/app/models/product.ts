
export class Product {
        id: string;
        productName: string;
        productDescription: string;
        unitPrice: number;
        imageUrl: string;
        productQuantity: number;
        productCategory:string;

        constructor(id='', productName='',productCategory='', productDescription = '', unitPrice = 0, productQuantity = 0, imageUrl = 'https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcR608TWmLRWFNYPlY5xgKkgZPYe7mwv0GDMDtAS9nRdlVo4aytG') {
                this.id = id
                this.productName = productName
                this.productDescription = productDescription
                this.unitPrice = unitPrice
                this.imageUrl = imageUrl
                this.productQuantity=productQuantity
                this.productCategory=productCategory
        }
}