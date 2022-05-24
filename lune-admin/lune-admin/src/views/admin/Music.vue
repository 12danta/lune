<template>
<div class="page_width">
   <el-table
    ref="multipleTable"
    :data="tableData"
    tooltip-effect="dark"
    style="width: 100%"
    @selection-change="handleSelectionChange">
    <el-table-column
      type="selection"
      width="55">
    </el-table-column>
    <el-table-column
      label="name"
      width="200">
      <template slot-scope="scope">{{ scope.row.name }}</template>
    </el-table-column>
    <el-table-column
      prop="Composer"
      label="Composer"
      width="120">
    </el-table-column>
    <el-table-column
      prop="movement"
      label="movement"
      show-overflow-tooltip>
               <template slot-scope="scope">
                <div>
                  <ul>
                    <li v-for="item in scope.row.movements" :key="item.movement">
                      {{ item.movement }}
                    </li>
                  </ul>
                </div>
              </template>
    </el-table-column>
    <el-table-column
      prop="Introduction"
      label="Introduction"
      show-overflow-tooltip>
    </el-table-column>

      <el-table-column
      prop="tag"
      label="tag"
      width="300"
      :filters="[{ text: 'cello', value: 'cello' }, { text: 'mozart', value: 'mozart'} ,{ text: 'Snatas', value: 'Snatas' }]"
      :filter-method="filterTag"
      filter-placement="bottom-end">

      <template slot-scope="scope">
        <div class="tags">
          <el-tag
          :type="scope.row.tag === 'cello' ? 'primary' : 'success'"
          v-for="item in scope.row.tags" :key="item.row"
          disable-transitions
          class="tag"
          >
          {{item.tag}}
          </el-tag>
        </div>
      </template>

    </el-table-column>

    <el-table-column >
       <template slot="header">
        <el-input
          v-model="search"
          size="mini"
          placeholder="searching..."/>
      </template>
      <template slot-scope="scope">
        <div class="operate">
          <el-button
          size="mini"
          @click="handleEdit(scope.$index, scope.row)">Edit</el-button>
        <el-button
          size="mini"
          type="danger"
          @click="handleDelete(scope.$index, scope.row);open()">Delete</el-button>
        </div>
      </template>
    </el-table-column>

  </el-table>
  <div style="margin-top: 20px">
    <el-button @click="toggleSelection([tableData[1], tableData[2]])">切换第二、第三行的选中状态</el-button>
    <el-button @click="toggleSelection()">取消选择</el-button>
  </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      tableData: [
        {
          name: 'Cello Sonata in E major, Op.19',
          Composer: 'Mozart, Franz Xaver Wolfgang',
          Introduction: 'a introduction',
          movements: [
            {movement: 'Allegro (E major)'},
            {movement: 'Andantino espressivo (B minor, ends B major)'},
            {movement: 'Allegro vivo (E major)'}
          ],
          tags: [
            {tag: 'cello'},
            {tag: 'mozart'},
            {tag: 'Snatas'}
          ]
        },
        {
          name: 'Cello Sonata in E major, Op.19',
          Composer: 'Mozart, Franz Xaver Wolfgang',
          movements: [
            {movement: 'Allegro (E major)'},
            {movement: 'Andantino espressivo (B minor, ends B major)'},
            {movement: 'Allegro vivo (E major)'}
          ],
          tags: [
            {tag: 'cello'},
            {tag: 'mozart'},
            {tag: 'Snatas'}
          ]
        },
        {
          name: 'Cello Sonata in E major, Op.19',
          Composer: 'Mozart, Franz Xaver Wolfgang',
          movements: [
            {movement: 'Allegro (E major)'},
            {movement: 'Andantino espressivo (B minor, ends B major)'},
            {movement: 'Allegro vivo (E major)'}
          ],
          tags: [
            {tag: 'cello'},
            {tag: 'mozart'},
            {tag: 'Snatas'}
          ]
        },
        {
          name: 'Cello Sonata in E major, Op.19',
          Composer: 'Mozart, Franz Xaver Wolfgang',
          movements: [
            {movement: 'Allegro (E major)'},
            {movement: 'Andantino espressivo (B minor, ends B major)'},
            {movement: 'Allegro vivo (E major)'}
          ],
          tags: [
            {tag: 'cello'},
            {tag: 'mozart'},
            {tag: 'Snatas'}
          ]
        },
        {
          name: 'Cello Sonata in E major, Op.19',
          Composer: 'Mozart, Franz Xaver Wolfgang',
          movements: [
            {movement: 'Allegro (E major)'},
            {movement: 'Andantino espressivo (B minor, ends B major)'},
            {movement: 'Allegro vivo (E major)'}
          ],
          tags: [
            {tag: 'cello'},
            {tag: 'mozart'},
            {tag: 'Snatas'}
          ]
        },
        {
          name: 'Cello Sonata in E major, Op.19',
          Composer: 'Mozart, Franz Xaver Wolfgang',
          movements: [
            {movement: 'Allegro (E major)'},
            {movement: 'Andantino espressivo (B minor, ends B major)'},
            {movement: 'Allegro vivo (E major)'}
          ],
          tags: [

            {tag: 'mozart'}
          ]
        }],
      search: '',
      multipleSelection: []
    }
  },
  methods: {
    toggleSelection (rows) {
      if (rows) {
        rows.forEach(row => {
          this.$refs.multipleTable.toggleRowSelection(row)
        })
      } else {
        this.$refs.multipleTable.clearSelection()
      }
    },
    handleSelectionChange (val) {
      this.multipleSelection = val
    },
    filterTag (value, row) {
      for (let item of row.tags) {
        return item.tag === value
      }
    },
    handleEdit (index, row) {
      console.log(index, row)
    },
    handleDelete (index, row) {
      console.log(index, row)
    },
    open () {
      this.$confirm('Are you sure to delete it?', 'Tip', {
        confirmButtonText: 'yes',
        cancelButtonText: 'no',
        type: 'warning'
      }).then(() => {
        this.$message({
          type: 'success',
          message: 'Deleted successfully!'
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: 'Deletions have been reversed'
        })
      })
    }
  }
}

</script>

<style>
  .tag{
    margin: 2px 2px;
  }
</style>
