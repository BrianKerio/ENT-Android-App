<?php

include '../../include/connections.php';


$clientID=$_POST['clientID'];

//creating a query
$select = "SELECT o.order_id,o.order_status,o.order_date,o.address,p.item_price,
          p.quantity,p.item_status FROM bookings o INNER JOIN order_items p on o.order_id = p.order_id
WHERE o.client_id='$clientID'ORDER BY o.order_id DESC";

  $query=mysqli_query($con,$select);
  if(mysqli_num_rows($query)>0){
      $results= array();
      $results['status'] = "1";
      $results['orders'] = array();
      $results['message']="Order history";
      while ($row=mysqli_fetch_array($query)){
          $temp = array();

          $temp['orderID'] = $row['order_id'];
          $temp['orderDate'] = $row['order_date'];
          $temp['orderCost'] = $row['item_price'];
          $temp['mpesaCode'] = $row['address'];
          $temp['shippingCost'] = $row['quantity'];
          $temp['itemCost'] = $row['item_price'];

               if($row['order_status']==1){
              $temp['orderStatus'] = "Pending";
          }elseif ($row['order_status']==2){
              $temp['orderStatus'] = "Approved";
          }elseif ( $row['order_status']==3){
              $temp['orderStatus'] = "Shipping";
          }elseif ($row['order_status']==4){
              $temp['orderStatus'] = "Pay Invoiced Amount";
          }elseif ($row['order_status']==5){
              $temp['orderStatus'] = "Invoice Paid";
          }
          elseif ($row['order_status']==6){
              $temp['orderStatus'] = "Invoice Paid";

          }elseif ($row['order_status']==7){
              $temp['orderStatus'] = "Confirm Completion";

          }elseif ($row['order_status']==8){
              $temp['orderStatus'] = "Service Completed";
          }
          array_push($results['orders'], $temp);

      }


  }else{
      $results['status'] = "0";
      $results['message'] = "No Invoice Found";

}
//displaying the result in json format
echo json_encode($results);



//$today = date('Ymd');
//$startDate = date('Ymd', strtotime('-100 days'));
//$range = $today - $startDate;
//$rand = rand(100, 999);
//echo $rand;
//echo "</br>";
//$random = substr(md5(mt_rand()), 0, 2);
//echo $random;

?>